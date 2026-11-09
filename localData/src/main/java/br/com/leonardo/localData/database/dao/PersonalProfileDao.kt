package br.com.leonardo.localData.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for [PersonalProfile] database operations.
 */
@Dao
interface PersonalProfileDao {
    /** Observes all inactive personal profiles. */
    @Query("SELECT * FROM PersonalProfile WHERE active = 0")
    fun getInactive(): Flow<List<PersonalProfile>>

    /** Observes all active personal profiles. */
    @Query("SELECT * FROM PersonalProfile WHERE active = 1")
    fun getActives(): Flow<List<PersonalProfile>>

    /** Retrieves a personal profile by ID. */
    @Query("SELECT * FROM PersonalProfile WHERE id = :id")
    suspend fun getById(id: String): PersonalProfile?

    /** Inserts or replaces a personal profile. */
    @Insert(onConflict = REPLACE)
    suspend fun insert(personalProfile: PersonalProfile)

    /** Removes a personal profile. */
    @Delete
    suspend fun remove(personalProfile: PersonalProfile)

    /** Updates an existing personal profile. */
    @Update
    suspend fun update(personalProfile: PersonalProfile)
}
