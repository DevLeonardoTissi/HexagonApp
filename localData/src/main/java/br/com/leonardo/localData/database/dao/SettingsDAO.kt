package br.com.leonardo.localData.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDAO {

    @Update
    suspend fun updateSettings(settings: Settings)

    @Query("SELECT * FROM settings")
    fun searchSettings(): Flow<Settings>

}