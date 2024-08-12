package br.com.leonardo.localData.repository.impl

import br.com.leonardo.localData.database.dao.PersonalProfileDao
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository

class PersonalProfileRepositoryImpl(private val dao: PersonalProfileDao) :
    PersonalProfileRepository {

    override fun getInactive() = dao.getInactive()

    override fun getActives() = dao.getActives()

    override suspend fun getById(id: String) = dao.getById(id = id)

    override suspend fun insert(personalProfile: PersonalProfile) =
        dao.insert(personalProfile = personalProfile)

    override suspend fun remove(personalProfile: PersonalProfile) =
        dao.remove(personalProfile = personalProfile)

}