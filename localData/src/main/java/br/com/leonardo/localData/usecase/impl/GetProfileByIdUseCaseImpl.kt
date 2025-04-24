package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.GetProfileByIdUseCase

class GetProfileByIdUseCaseImpl(private val repository: PersonalProfileRepository) :
    GetProfileByIdUseCase {
    override suspend fun invoke(id: String) : PersonalProfile =
        repository.getById(id)
}