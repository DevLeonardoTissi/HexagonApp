package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.InsertProfileUseCase

class InsertProfileUseCaseImpl(private val repository: PersonalProfileRepository) :
    InsertProfileUseCase {
    override suspend fun invoke(personalProfile: PersonalProfile) =
        repository.insert(personalProfile)
}