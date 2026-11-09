package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.repository.SettingsRepository
import br.com.leonardo.localData.usecase.SearchSettingsUseCase
import kotlinx.coroutines.flow.Flow

/** Implementation of [SearchSettingsUseCase] delegating to [SettingsRepository]. */
class SearchSettingsUseCaseImpl(
    private val repository: SettingsRepository,
) : SearchSettingsUseCase {
    override fun invoke(): Flow<Settings> = repository.searchSettings()
}
