package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.GetInactivesProfilesUseCase
import kotlinx.coroutines.flow.Flow

class GetInactivesProfilesUseCaseImpl(private val repository: PersonalProfileRepository):
    GetInactivesProfilesUseCase {
    override fun invoke(): Flow<List<PersonalProfile>> = repository.getInactives()
}