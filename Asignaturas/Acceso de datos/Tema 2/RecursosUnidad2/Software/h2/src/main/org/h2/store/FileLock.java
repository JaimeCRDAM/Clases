/*
 * Copyright 2004-2011 H2 Group. Multiple-Licensed under the H2 License,
 * Version 1.0, and under the Eclipse Public License, Version 1.0
 * (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.store;

import java.io.IOException;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import org.h2.constant.ErrorCode;
import org.h2.engine.Constants;
import org.h2.engine.SessionRemote;
import org.h2.message.DbException;
import org.h2.message.Trace;
import org.h2.message.TraceSystem;
import org.h2.store.fs.FileUtils;
import org.h2.util.MathUtils;
import org.h2.util.NetUtils;
import org.h2.util.SortedProperties;
import org.h2.util.StringUtils;
import org.h2.value.Transfer;

/**
 * The file lock is used to lock a database so that only one process can write
 * to it. It uses a cooperative locking protocol. Usually a .lock.db file is
 * used, but locking by creating a socket is supported as well.
 */
public class FileLock implements Runnable {

    /**
     * This locking method means no locking is used at all.
     */
    public static final int LOCK_NO = 0;

    /**
     * This locking method means the cooperative file locking protocol should be
     * used.
     */
    public static final int LOCK_FILE = 1;

    /**
     * This locking method means a socket is created on the given machine.
     */
    public static final int LOCK_SOCKET = 2;

    /**
     * This locking method means multiple writers are allowed, and they
     * synchronize themselves.
     */
    public static final int LOCK_SERIALIZED = 3;

    /**
     * Use the file system to lock the file; don't use a separate lock file.
     */
    public static final int LOCK_FS = 4;

    private static final String MAGIC = "FileLock";
    private static final String FILE = "file", SOCKET = "socket", SERIALIZED = "serialized";
    private static final int RANDOM_BYTES = 16;
    private static final int SLEEP_GAP = 25;
    private static final int TIME_GRANULARITY = 2000;

    /**
     * The lock file name.
     */
    private volatile String fileName;

    /**
     * The server socket (only used when using the SOCKET mode).
     */
    private volatile ServerSocket serverSocket;

    /**
     * The number of milliseconds to sleep after checking a file.
     */
    private int sleep;

    /**
     * The trace object.
     */
    private Trace trace;

    /**
     * The last time the lock file was written.
     */
    private long lastWrite;

    private String method, ipAddress;
    private Properties properties;
    private boolean locked;
    private String uniqueId;
    private Thread watchdog;

    /**
     * Create a new file locking object.
     *
     * @param traceSystem the trace system to use
     * @param fileName the file name
     * @param sleep the number of milliseconds to sleep
     */
    public FileLock(TraceSystem traceSystem, String fileName, int sleep) {
        this.trace = traceSystem == null ? null : traceSystem.getTrace(Trace.FILE_LOCK);
        this.fileName = fileName;
        this.sleep = sleep;
    }

    /**
     * Lock the file if possible. A file may only be locked once.
     *
     * @param fileLockMethod the file locking method to use
     * @throws DbException if locking was not successful
     */
    public synchronized void lock(int fileLockMethod) {
        checkServer();
        if (locked) {
            DbException.throwInternalError("already locked");
        }
        switch (fileLockMethod) {
        case LOCK_FILE:
            lockFile();
            break;
        case LOCK_SOCKET:
            lockSocket();
            break;
        case LOCK_SERIALIZED:
            lockSerialized();
            break;
        case LOCK_FS:
            break;
        }
        locked = true;
    }

    /**
     * Unlock the file. The watchdog thread is stopped. This method does nothing
     * if the file is already unlocked.
     */
    public synchronized void unlock() {
        if (!locked) {
            return;
        }
        try {
            if (fileName != null) {
                if (load().equals(properties)) {
                    FileUtils.delete(fileName);
                }
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception e) {
            trace.debug(e, "unlock");
        } finally {
            fileName = null;
            serverSocket = null;
            locked = false;
        }
        try {
            if (watchdog != null) {
                watchdog.interrupt();
            }
        } catch (Exception e) {
            trace.debug(e, "unlock");
        }
    }

    /**
     * Add or change a setting to the properties. This call does not save the
     * file.
     *
     * @param key the key
     * @param value the value
     */
    public void setProperty(String key, String value) {
        if (value == null) {
            properties.remove(key);
        } else {
            properties.put(key, value);
        }
    }

    /**
     * Save the lock file.
     *
     * @return the saved properties
     */
    public Properties save() {
        try {
            OutputStream out = FileUtils.newOutputStream(fileName, false);
            try {
                properties.store(out, MAGIC);
            } finally {
                out.close();
            }
            lastWrite = FileUtils.lastModified(fileName);
            if (trace.isDebugEnabled()) {
                trace.debug("save " + properties);
            }
            return properties;
        } catch (IOException e) {
            throw getExceptionFatal("Could not save properties " + fileName, e);
        }
    }

    private void checkServer() {
        Properties prop = load();
        String server = prop.getProperty("server");
        if (server == null) {
            return;
        }
        boolean running = false;
        String id = prop.getProperty("id");
        try {
            Socket socket = NetUtils.createSocket(server, Constants.DEFAULT_TCP_PORT, false);
            Transfer transfer = new Transfer(null);
            transfer.setSocket(socket);
            transfer.init();
            transfer.writeInt(Constants.TCP_PROTOCOL_VERSION_6);
            transfer.writeInt(Constants.TCP_PROTOCOL_VERSION_10);
            transfer.writeString(null);
            transfer.writeString(null);
            transfer.writeString(id);
            transfer.writeInt(SessionRemote.SESSION_CHECK_KEY);
            transfer.flush();
            int state = transfer.readInt();
            if (state == SessionRemote.STATUS_OK) {
                running = true;
            }
            transfer.close();
            socket.close();
        } catch (IOException e) {
            return;
        }
        if (running) {
            DbException e = DbException.get(ErrorCode.DATABASE_ALREADY_OPEN_1, "Server is running");
            throw e.addSQL(server + "/" + id);
        }
    }

    /**
     * Load the properties file.
     *
     * @return the properties
     */
    public Properties load() {
        IOException lastException = null;
        for (int i = 0; i < 5; i++) {
            try {
                Properties p2 = SortedProperties.loadProperties(fileName);
                if (trace.isDebugEnabled()) {
                    trace.debug("load " + p2);
                }
                return p2;
            } catch (IOException e) {
                lastException = e;
            }
        }
        throw getExceptionFatal("Could not load properties " + fileName, lastException);
    }

    private void waitUntilOld() {
        for (int i = 0; i < 2 * TIME_GRANULARITY / SLEEP_GAP; i++) {
            long last = FileUtils.lastModified(fileName);
            long dist = System.currentTimeMillis() - last;
            if (dist < -TIME_GRANULARITY) {
                // lock file modified in the future -
                // wait for a bit longer than usual
                try {
                    Thread.sleep(2 * (long) sleep);
                } catch (Exception e) {
                    trace.debug(e, "sleep");
                }
                return;
            } else if (dist > TIME_GRANULARITY) {
                return;
            }
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (Exception e) {
                trace.debug(e, "sleep");
            }
        }
        throw getExceptionFatal("Lock file recently modified", null);
    }

    private void setUniqueId() {
        byte[] bytes = MathUtils.secureRandomBytes(RANDOM_BYTES);
        String random = StringUtils.convertBytesToHex(bytes);
        uniqueId = Long.toHexString(System.currentTimeMillis()) + random;
        properties.setProperty("id", uniqueId);
    }

    private void lockSerialized() {
        method = SERIALIZED;
        FileUtils.createDirectories(FileUtils.getParent(fileName));
        if (FileUtils.createFile(fileName)) {
            properties = new SortedProperties();
            properties.setProperty("method", String.valueOf(method));
            setUniqueId();
            save();
        } else {
            while (true) {
                try {
                    properties = load();
                } catch (DbException e) {
                    // ignore
                }
                return;
            }
        }
    }

    private void lockFile() {
        method = FILE;
        properties = new SortedProperties();
        properties.setProperty("method", String.valueOf(method));
        setUniqueId();
        FileUtils.createDirectories(FileUtils.getParent(fileName));
        if (!FileUtils.createFile(fileName)) {
            waitUntilOld();
            String m2 = load().getProperty("method", FILE);
            if (!m2.equals(FILE)) {
                throw getExceptionFatal("Unsupported lock method " + m2, null);
            }
            save();
            sleep(2 * sleep);
            if (!load().equals(properties)) {
                throw getExceptionAlreadyInUse("Locked by another process");
            }
            FileUtils.delete(fileName);
            if (!FileUtils.createFile(fileName)) {
                throw getExceptionFatal("Another process was faster", null);
            }
        }
        save();
        sleep(SLEEP_GAP);
        if (!load().equals(properties)) {
            fileName = null;
            throw getExceptionFatal("Concurrent update", null);
        }
        watchdog = new Thread(this, "H2 File Lock Watchdog " + fileName);
        watchdog.setDaemon(true);
        watchdog.setPriority(Thread.MAX_PRIORITY - 1);
        watchdog.start();
    }

    private void lockSocket() {
        method = SOCKET;
        properties = new SortedProperties();
        properties.setProperty("method", String.valueOf(method));
        setUniqueId();
        // if this returns 127.0.0.1,
        // the computer is probably not networked
        ipAddress = NetUtils.getLocalAddress();
        FileUtils.createDirectories(FileUtils.getParent(fileName));
        if (!FileUtils.createFile(fileName)) {
            waitUntilOld();
            long read = FileUtils.lastModified(fileName);
            Properties p2 = load();
            String m2 = p2.getProperty("method", SOCKET);
            if (m2.equals(FILE)) {
                lockFile();
                return;
            } else if (!m2.equals(SOCKET)) {
                throw getExceptionFatal("Unsupported lock method " + m2, null);
            }
            String ip = p2.getProperty("ipAddress", ipAddress);
            if (!ipAddress.equals(ip)) {
                throw getExceptionAlreadyInUse("Locked by another computer: " + ip);
            }
            String port = p2.getProperty("port", "0");
            int portId = Integer.parseInt(port);
            InetAddress address;
            try {
                address = InetAddress.getByName(ip);
            } catch (UnknownHostException e) {
                throw getExceptionFatal("Unknown host " + ip, e);
            }
            for (int i = 0; i < 3; i++) {
                try {
                    Socket s = new Socket(address, portId);
                    s.close();
                    throw getExceptionAlreadyInUse("Locked by another process");
                } catch (BindException e) {
                    throw getExceptionFatal("Bind Exception", null);
                } catch (ConnectException e) {
                    trace.debug(e, "socket not connected to port " + port);
                } catch (IOException e) {
                    throw getExceptionFatal("IOException", null);
                }
            }
            if (read != FileUtils.lastModified(fileName)) {
                throw getExceptionFatal("Concurrent update", null);
            }
            FileUtils.delete(fileName);
            if (!FileUtils.createFile(fileName)) {
                throw getExceptionFatal("Another process was faster", null);
            }
        }
        try {
            // 0 to use any free port
            serverSocket = NetUtils.createServerSocket(0, false);
            int port = serverSocket.getLocalPort();
            properties.setProperty("ipAddress", ipAddress);
            properties.setProperty("port", String.valueOf(port));
        } catch (Exception e) {
            trace.debug(e, "lock");
            serverSocket = null;
            lockFile();
            return;
        }
        save();
        watchdog = new Thread(this, "H2 File Lock Watchdog (Socket) " + fileName);
        watchdog.setDaemon(true);
        watchdog.start();
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw getExceptionFatal("Sleep interrupted", e);
        }
    }

    private static DbException getExceptionFatal(String reason, Throwable t) {
        return DbException.get(ErrorCode.ERROR_OPENING_DATABASE_1, t, reason);
    }

    private DbException getExceptionAlreadyInUse(String reason) {
        DbException e = DbException.get(ErrorCode.DATABASE_ALREADY_OPEN_1, reason);
        if (fileName != null) {
            try {
                Properties prop = load();
                String server = prop.getProperty("server");
                if (server != null) {
                    String serverId = server + "/" + prop.getProperty("id");
                    e = e.addSQL(serverId);
                }
            } catch (DbException e2) {
                // ignore
            }
        }
        return e;
    }

    /**
     * Get the file locking method type given a method name.
     *
     * @param method the method name
     * @return the method type
     * @throws DbException if the method name is unknown
     */
    public static int getFileLockMethod(String method) {
        if (method == null || method.equalsIgnoreCase("FILE")) {
            return FileLock.LOCK_FILE;
        } else if (method.equalsIgnoreCase("NO")) {
            return FileLock.LOCK_NO;
        } else if (method.equalsIgnoreCase("SOCKET")) {
            return FileLock.LOCK_SOCKET;
        } else if (method.equalsIgnoreCase("SERIALIZED")) {
            return FileLock.LOCK_SERIALIZED;
        } else if (method.equalsIgnoreCase("FS")) {
            return FileLock.LOCK_FS;
        } else {
            throw DbException.get(ErrorCode.UNSUPPORTED_LOCK_METHOD_1, method);
        }
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void run() {
        try {
            while (fileName != null) {
                // trace.debug("watchdog check");
                try {
                    if (!FileUtils.exists(fileName) || FileUtils.lastModified(fileName) != lastWrite) {
                        save();
                    }
                    Thread.sleep(sleep);
                } catch (OutOfMemoryError e) {
                    // ignore
                } catch (InterruptedException e) {
                    // ignore
                } catch (NullPointerException e) {
                    // ignore
                } catch (Exception e) {
                    trace.debug(e, "watchdog");
                }
            }
            while (serverSocket != null) {
                try {
                    trace.debug("watchdog accept");
                    Socket s = serverSocket.accept();
                    s.close();
                } catch (Exception e) {
                    trace.debug(e, "watchdog");
                }
            }
        } catch (Exception e) {
            trace.debug(e, "watchdog");
        }
        trace.debug("watchdog end");
    }

}
