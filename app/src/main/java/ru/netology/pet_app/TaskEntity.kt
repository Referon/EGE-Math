package ru.netology.pet_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: String,
    val message: String,
    val answer: String,
    val decided: Boolean,
    val picture: Int? = null
)
