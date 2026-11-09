package br.com.leonardo.localData.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for application [Settings] database operations.
 */
@Dao
interface SettingsDAO {
    /** Updates stored application settings. */
    @Update
    suspend fun updateSettings(settings: Settings)

    /** Observes current application settings. */
    @Query("SELECT * FROM settings")
    fun searchSettings(): Flow<Settings>
}
