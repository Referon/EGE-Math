package ru.netology.pet_app.data

data class TaskVariant(
    val id: Int,
    val type: Int,
    val message: String,
    val answer: String,
    val picture: String? = "",
    val decided: Int
)
