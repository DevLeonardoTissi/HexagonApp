package br.com.leonardo.hexagonapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class PersonalProfile(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val cpf: String,
    var name: String,
    val city: String,
    val dateOfBirth: String,
    val active: Boolean = true,
    val photo: String? = null
)