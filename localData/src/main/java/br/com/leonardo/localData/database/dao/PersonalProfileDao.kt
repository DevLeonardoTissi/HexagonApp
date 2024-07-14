package br.com.leonardo.localData.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import br.com.leonardo.localData.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonalProfileDao {

    @Query("SELECT * FROM PersonalProfile WHERE active = 0")
    fun getInactive(): Flow<List<PersonalProfile>>

    @Query("SELECT * FROM PersonalProfile WHERE active = 1")
    fun getActives(): Flow<List<PersonalProfile>>

    @Query("SELECT * FROM PersonalProfile WHERE id = :id")
    suspend fun getById(id: String): PersonalProfile

    @Insert(onConflict = REPLACE)
    suspend fun insert(personalProfile: PersonalProfile)

    @Delete
    suspend fun remove(personalProfile: PersonalProfile)

}