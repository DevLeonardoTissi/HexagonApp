package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile

/** Use case interface for retrieving a personal profile by ID. */
interface GetProfileByIdUseCase {
    /** Fetches profile details by unique identifier. */
    suspend operator fun invoke(id: String): PersonalProfile?
}
