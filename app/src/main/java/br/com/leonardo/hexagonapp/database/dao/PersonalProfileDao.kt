package br.com.leonardo.hexagonapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import br.com.leonardo.hexagonapp.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonalProfileDao {

    @Query("SELECT * FROM PersonalProfile WHERE active = 0")
    fun getInactives(): Flow<List<PersonalProfile>>

    @Query("SELECT * FROM PersonalProfile WHERE active = 1")
    fun getActives(): Flow<List<PersonalProfile>>

    @Query("SELECT * FROM PersonalProfile WHERE cpf = :cpf")
    fun getByCpf(cpf: String): Flow<PersonalProfile>

    @Query("UPDATE PersonalProfile SET active = 1 WHERE cpf = :cpf")
    suspend fun active(cpf: String)

    @Query("UPDATE PersonalProfile SET active = 0 WHERE cpf = :cpf")
    suspend fun inactive(cpf: String)

    @Insert(onConflict = REPLACE)
    suspend fun add(personalProfile: PersonalProfile)

    @Delete
    suspend fun remove(personalProfile: PersonalProfile)

}