package br.com.leonardo.localData.repository

import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for managing personal profile local data.
 */
interface PersonalProfileRepository {
    /** Observes inactive personal profiles. */
    fun getInactives(): Flow<List<PersonalProfile>>

    /** Observes active personal profiles. */
    fun getActives(): Flow<List<PersonalProfile>>

    /** Fetches a profile by unique identifier. */
    suspend fun getById(id: String): PersonalProfile?

    /** Inserts or replaces a personal profile. */
    suspend fun insert(personalProfile: PersonalProfile)

    /** Removes a personal profile from database. */
    suspend fun remove(personalProfile: PersonalProfile)

    /** Updates a personal profile entry. */
    suspend fun update(personalProfile: PersonalProfile)
}
