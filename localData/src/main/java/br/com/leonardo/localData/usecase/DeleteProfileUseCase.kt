package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile

/** Use case interface for removing a personal profile. */
interface DeleteProfileUseCase {
    /** Removes personal profile from local database. */
    suspend operator fun invoke(personalProfile: PersonalProfile)
}
