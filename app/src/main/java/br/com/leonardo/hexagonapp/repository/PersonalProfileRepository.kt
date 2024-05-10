package br.com.leonardo.hexagonapp.repository

import br.com.leonardo.hexagonapp.database.dao.PersonalProfileDao
import br.com.leonardo.hexagonapp.model.PersonalProfile

class PersonalProfileRepository(private val dao: PersonalProfileDao) {

    fun getInactive() = dao.getInactive()

    fun getActives() = dao.getActives()

    suspend fun getById(id: String) = dao.getById(id = id)

    suspend fun insert(personalProfile: PersonalProfile) =
        dao.insert(personalProfile = personalProfile)

    suspend fun remove(personalProfile: PersonalProfile) =
        dao.remove(personalProfile = personalProfile)


}