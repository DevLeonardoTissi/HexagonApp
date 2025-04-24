package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

interface SearchSettingsUseCase {
    operator fun invoke(): Flow<Settings>
}