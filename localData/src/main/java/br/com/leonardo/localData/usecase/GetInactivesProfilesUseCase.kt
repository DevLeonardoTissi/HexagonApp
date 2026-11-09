package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

/** Use case interface for observing inactive personal profiles stream. */
interface GetInactivesProfilesUseCase {
    /** Observes list of inactive personal profiles. */
    operator fun invoke(): Flow<List<PersonalProfile>>
}
