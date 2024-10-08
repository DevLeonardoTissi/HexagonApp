package br.com.leonardo.localData.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class PersonalProfile(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val cpf: String,
    val name: String,
    val city: String,
    val dateOfBirth: String,
    val active: Boolean = true,
    val photo: String? = null
)