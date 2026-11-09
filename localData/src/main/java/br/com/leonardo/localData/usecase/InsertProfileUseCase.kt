package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile

/** Use case interface for inserting a personal profile into database. */
interface InsertProfileUseCase {
    /** Inserts personal profile after formatting CPF document number. */
    suspend operator fun invoke(personalProfile: PersonalProfile)
}
