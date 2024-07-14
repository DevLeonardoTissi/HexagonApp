package br.com.leonardo.localData.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSettings(settings: Settings)

    @Query("SELECT * FROM settings")
    fun searchSettings(): Flow<Settings>

}