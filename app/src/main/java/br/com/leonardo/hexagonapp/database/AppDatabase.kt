package br.com.leonardo.hexagonapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.leonardo.hexagonapp.database.dao.PersonalProfileDao
import br.com.leonardo.hexagonapp.model.PersonalProfile

@Database(entities = [PersonalProfile::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val personalProfileDao: PersonalProfileDao
}