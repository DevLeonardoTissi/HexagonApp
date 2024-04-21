package br.com.leonardo.hexagonapp.repository

import br.com.leonardo.hexagonapp.database.dao.PersonalProfileDao
import br.com.leonardo.hexagonapp.model.PersonalProfile

class PersonalProfileRepository(private val dao: PersonalProfileDao) {

    fun getInactives() = dao.getInactives()

    fun getActives() = dao.getActives()

    fun getByCpf(cpf: String) = dao.getByCpf(cpf = cpf)

    suspend fun active(cpf: String) = dao.active(cpf = cpf)

    suspend fun inactive(cpf: String) = dao.inactive(cpf = cpf)

    suspend fun add(personalProfile: PersonalProfile) = dao.add(personalProfile = personalProfile)

    suspend fun remove(personalProfile: PersonalProfile) =
        dao.remove(personalProfile = personalProfile)


}