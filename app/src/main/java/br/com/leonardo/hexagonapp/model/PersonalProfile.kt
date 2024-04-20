package br.com.leonardo.hexagonapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PersonalProfile(

    @PrimaryKey
    val cpf: String,
    val name: String,
    val city: String,
    val dateOfBirth: String,
    val active: Boolean? = true,
    val photo: String? = null,

    ) {
}