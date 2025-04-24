package br.com.leonardo.localData.source.local

import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsLocalSource {

    fun searchSettings(): Flow<Settings>

    suspend fun updateSettings(settings: Settings)
}