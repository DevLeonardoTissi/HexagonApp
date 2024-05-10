package br.com.leonardo.hexagonapp.repository

import br.com.leonardo.hexagonapp.database.dao.SettingsDAO
import br.com.leonardo.hexagonapp.model.Settings

class SettingsRepository(private val dao: SettingsDAO) {
    fun searchSettings() = dao.searchSettings()
    suspend fun updateSettings(settings: Settings) = dao.updateSettings(settings)

}