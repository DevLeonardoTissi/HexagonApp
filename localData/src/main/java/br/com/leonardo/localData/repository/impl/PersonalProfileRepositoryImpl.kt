package br.com.leonardo.localData.repository.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.source.local.PersonalProfileLocalSource

class PersonalProfileRepositoryImpl(private val personalProfileLocalSource: PersonalProfileLocalSource) :
    PersonalProfileRepository {

    override fun getInactives() = personalProfileLocalSource.getInactive()

    override fun getActives() = personalProfileLocalSource.getActives()

    override suspend fun getById(id: String) = personalProfileLocalSource.getById(id = id)

    override suspend fun insert(personalProfile: PersonalProfile) =
        personalProfileLocalSource.insert(personalProfile = personalProfile)

    override suspend fun remove(personalProfile: PersonalProfile) =
        personalProfileLocalSource.remove(personalProfile = personalProfile)

    override suspend fun update(personalProfile: PersonalProfile) {
        personalProfileLocalSource.update(personalProfile = personalProfile)
    }

}