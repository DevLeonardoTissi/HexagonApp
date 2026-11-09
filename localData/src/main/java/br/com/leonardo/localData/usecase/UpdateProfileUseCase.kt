package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile

/** Use case interface for toggling active status or updating personal profiles. */
interface UpdateProfileUseCase {
    /** Updates personal profile entry in local database. */
    suspend operator fun invoke(personalProfile: PersonalProfile)
}
