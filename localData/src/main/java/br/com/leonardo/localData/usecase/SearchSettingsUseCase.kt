package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.Settings
import kotlinx.coroutines.flow.Flow

/** Use case interface for observing application settings. */
interface SearchSettingsUseCase {
    /** Observes current settings stream. */
    operator fun invoke(): Flow<Settings>
}
