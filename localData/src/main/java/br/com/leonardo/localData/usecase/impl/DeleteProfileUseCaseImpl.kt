package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.DeleteProfileUseCase

class DeleteProfileUseCaseImpl(private val repository: PersonalProfileRepository) :
    DeleteProfileUseCase {
    override suspend fun invoke(personalProfile: PersonalProfile) =
        repository.remove(personalProfile)
}