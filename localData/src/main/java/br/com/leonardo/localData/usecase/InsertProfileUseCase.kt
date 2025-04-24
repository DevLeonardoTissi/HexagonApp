package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile

interface InsertProfileUseCase {
    suspend operator fun invoke(personalProfile: PersonalProfile)
}