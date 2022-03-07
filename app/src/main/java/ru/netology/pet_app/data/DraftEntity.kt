package ru.netology.pet_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DraftEntity(
    @PrimaryKey
    val message: String
) {
}