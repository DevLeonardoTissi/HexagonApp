package br.com.leonardo.hexagonapp.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class DatabaseSettingsCallback: RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        db.execSQL("INSERT INTO `Settings` (`id`, `darkMode`) VALUES (1, 0)")
    }
}