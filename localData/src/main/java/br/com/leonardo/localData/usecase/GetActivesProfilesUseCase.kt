package br.com.leonardo.localData.usecase

import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

interface GetActivesProfilesUseCase {
    operator fun invoke() : Flow<List<PersonalProfile>>
}