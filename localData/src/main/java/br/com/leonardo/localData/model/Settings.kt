package br.com.leonardo.localData.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Settings(
    @PrimaryKey
    val id: Int = 1,
    val darkMode: Boolean = false
)