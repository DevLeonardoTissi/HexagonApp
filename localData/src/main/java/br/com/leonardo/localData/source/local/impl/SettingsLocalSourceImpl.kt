package br.com.leonardo.localData.source.local.impl

import br.com.leonardo.localData.database.dao.SettingsDAO
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.source.local.SettingsLocalSource
import kotlinx.coroutines.flow.Flow

class SettingsLocalSourceImpl(private val dao: SettingsDAO) : SettingsLocalSource {
    override fun searchSettings(): Flow<Settings> = dao.searchSettings()

    override suspend fun updateSettings(settings: Settings) = dao.updateSettings(settings)
}