package br.com.leonardo.localData.repository

import br.com.leonardo.localData.database.dao.SettingsDAO
import br.com.leonardo.localData.model.Settings

class SettingsRepository(private val dao: SettingsDAO) {
    fun searchSettings() = dao.searchSettings()
    suspend fun updateSettings(settings: Settings) = dao.updateSettings(settings)

}