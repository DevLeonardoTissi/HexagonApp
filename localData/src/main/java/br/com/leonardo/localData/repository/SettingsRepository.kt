package br.com.leonardo.localData.repository

import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for reading and writing application settings.
 */
interface SettingsRepository {
    /** Observes application settings updates. */
    fun searchSettings(): Flow<Settings>

    /** Persists updated application settings. */
    suspend fun updateSettings(settings: Settings)
}
