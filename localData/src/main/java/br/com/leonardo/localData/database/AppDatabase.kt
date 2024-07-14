package br.com.leonardo.localData.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.leonardo.localData.database.dao.PersonalProfileDao
import br.com.leonardo.localData.database.dao.SettingsDAO
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.model.Settings

@Database(entities = [PersonalProfile::class, Settings::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val personalProfileDao: PersonalProfileDao
    abstract val settingsDao: SettingsDAO
}