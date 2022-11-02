package Modelo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FeedReaderDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createTableQuery)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "sqlitedb.db"
        private val TABLE_NAME = "mydb"
        private val id = "id"
        private val nombre = "name"
        private val raza = "raza"
        val createTableQuery = (
                "CREATE TABLE ${TABLE_NAME}(${id} INTEGER PRIMARY KEY, $nombre TEXT, $raza TEXT)"
                )
        private val SQL_DELETE_ENTRIES = ("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    private fun existe(context: Context): Boolean {
        return context.getDatabasePath(DATABASE_NAME).exists()
    }
}