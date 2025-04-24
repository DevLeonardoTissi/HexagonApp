package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.repository.SettingsRepository
import br.com.leonardo.localData.usecase.UpdateSettingsUseCase

class UpdateSettingsUseCaseImpl(private val repository: SettingsRepository) :
    UpdateSettingsUseCase {
    override suspend fun invoke(settings: Settings) = repository.updateSettings(settings)
}