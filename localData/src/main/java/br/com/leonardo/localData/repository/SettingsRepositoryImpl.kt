package br.com.leonardo.localData.repository

import br.com.leonardo.localData.database.dao.SettingsDAO
import br.com.leonardo.localData.model.Settings

class SettingsRepositoryImpl(private val dao: SettingsDAO):  SettingsRepository {

    override fun searchSettings() = dao.searchSettings()

    override suspend fun updateSettings(settings: Settings) = dao.updateSettings(settings)

}