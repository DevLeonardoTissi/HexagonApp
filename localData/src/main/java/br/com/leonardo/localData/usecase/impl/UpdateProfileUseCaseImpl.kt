package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.UpdateProfileUseCase

class UpdateProfileUseCaseImpl(private val repository: PersonalProfileRepository) :
    UpdateProfileUseCase {
    override suspend fun invoke(personalProfile: PersonalProfile) =
        repository.update(personalProfile.copy(active = !personalProfile.active))
}