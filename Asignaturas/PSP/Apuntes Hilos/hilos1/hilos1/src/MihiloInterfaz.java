public class MihiloInterfaz implements Runnable {
    public void run(){
        System.out.println("Hilo Runnable" + Thread.currentThread().getName());
    }
}