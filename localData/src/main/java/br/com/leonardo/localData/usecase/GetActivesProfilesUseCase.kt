package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

/** Use case interface for observing active personal profiles stream. */
interface GetActivesProfilesUseCase {
    /** Observes list of active personal profiles. */
    operator fun invoke(): Flow<List<PersonalProfile>>
}
