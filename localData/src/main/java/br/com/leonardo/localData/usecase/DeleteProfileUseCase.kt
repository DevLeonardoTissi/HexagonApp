package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile

interface DeleteProfileUseCase {
    suspend operator fun invoke(personalProfile: PersonalProfile)
}