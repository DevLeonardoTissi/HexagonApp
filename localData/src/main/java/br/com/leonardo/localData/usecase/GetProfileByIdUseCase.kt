package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile

interface GetProfileByIdUseCase {
    suspend operator fun invoke(id: String) : PersonalProfile?
}