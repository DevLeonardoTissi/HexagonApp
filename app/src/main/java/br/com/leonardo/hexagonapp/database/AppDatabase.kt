package br.com.leonardo.hexagonapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.leonardo.hexagonapp.database.dao.PersonalProfileDao
import br.com.leonardo.hexagonapp.database.dao.SettingsDAO
import br.com.leonardo.hexagonapp.model.PersonalProfile
import br.com.leonardo.hexagonapp.model.Settings

@Database(entities = [PersonalProfile::class, Settings::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val personalProfileDao: PersonalProfileDao
    abstract val settingsDao: SettingsDAO
}