package br.com.leonardo.localData.repository

import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun searchSettings(): Flow<Settings>

    suspend fun updateSettings(settings: Settings)

}