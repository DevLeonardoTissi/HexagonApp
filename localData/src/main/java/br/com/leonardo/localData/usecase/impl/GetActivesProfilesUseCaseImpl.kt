package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.GetActivesProfilesUseCase
import kotlinx.coroutines.flow.Flow

class GetActivesProfilesUseCaseImpl(private val repository: PersonalProfileRepository) :
    GetActivesProfilesUseCase {
    override fun invoke(): Flow<List<PersonalProfile>> = repository.getActives()
}