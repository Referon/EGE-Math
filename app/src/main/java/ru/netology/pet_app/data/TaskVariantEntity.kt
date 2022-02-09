package ru.netology.pet_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskVariantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: Int,
    val message: String,
    val answer: String,
    val picture: Int? = null,
    val decided: Int
)
