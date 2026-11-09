package br.com.leonardo.localData.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing application user preferences stored in Room database.
 *
 * @property id Primary key (fixed default = 1 for single row settings).
 * @property darkMode Flag indicating dark theme preference.
 * @property showNotification Flag indicating notification preferences.
 */
@Entity
data class Settings(
    @PrimaryKey
    val id: Int = 1,
    val darkMode: Boolean = false,
    val showNotification: Boolean = false,
)
