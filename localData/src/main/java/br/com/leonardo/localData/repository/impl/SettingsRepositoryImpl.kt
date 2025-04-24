package br.com.leonardo.localData.repository.impl

import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.repository.SettingsRepository
import br.com.leonardo.localData.source.local.SettingsLocalSource

class SettingsRepositoryImpl(private val settingsLocalSource: SettingsLocalSource) :
    SettingsRepository {

    override fun searchSettings() = settingsLocalSource.searchSettings()

    override suspend fun updateSettings(settings: Settings) =
        settingsLocalSource.updateSettings(settings)

}