package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.Settings

interface UpdateSettingsUseCase {
   suspend operator fun invoke(settings: Settings)
}