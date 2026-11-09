package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.Settings

/** Use case interface for updating application preferences. */
interface UpdateSettingsUseCase {
    /** Saves updated application settings to local database. */
    suspend operator fun invoke(settings: Settings)
}
