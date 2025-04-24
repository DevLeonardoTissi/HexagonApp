package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

interface GetInactivesProfilesUseCase {
    operator fun invoke() : Flow<List<PersonalProfile>>
}