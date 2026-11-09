package br.com.leonardo.localData.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Entity representing a personal profile stored in Room database.
 *
 * @property id Unique record identifier.
 * @property cpf Profile CPF document number.
 * @property name Profile full name.
 * @property city Profile city.
 * @property dateOfBirth Date of birth timestamp in milliseconds.
 * @property active Flag indicating whether profile is active.
 * @property photo Optional profile avatar image URL.
 */
@Entity
data class PersonalProfile(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val cpf: String,
    val name: String,
    val city: String,
    val dateOfBirth: Long,
    val active: Boolean = true,
    val photo: String? = null,
)
