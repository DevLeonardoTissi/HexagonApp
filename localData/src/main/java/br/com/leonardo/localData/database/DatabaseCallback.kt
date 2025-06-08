package br.com.leonardo.localData.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class DatabaseSettingsCallback: RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        db.execSQL("INSERT INTO `Settings` (`id`, `darkMode`, `showNotification`) VALUES (1, 0, 0)")
    }
}