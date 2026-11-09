package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.UpdateProfileUseCase

/** Implementation of [UpdateProfileUseCase] delegating to [PersonalProfileRepository]. */
class UpdateProfileUseCaseImpl(
    private val repository: PersonalProfileRepository,
) : UpdateProfileUseCase {
    override suspend fun invoke(personalProfile: PersonalProfile) =
        repository.update(personalProfile.copy(active = !personalProfile.active))
}
