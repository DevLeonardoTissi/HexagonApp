package br.com.leonardo.localData.source.local

import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

interface PersonalProfileLocalSource {

    fun getInactive() : Flow<List<PersonalProfile>>

    fun getActives() : Flow<List<PersonalProfile>>

    suspend fun getById(id: String) : PersonalProfile

    suspend fun insert(personalProfile: PersonalProfile)

    suspend fun remove(personalProfile: PersonalProfile)

    suspend fun update(personalProfile: PersonalProfile)

}