package ru.netology.pet_app.data

data class Task(
    val id: Int,
    val type: Int,
    val message: String,
    val answer: String,
    val decided: Boolean,
    val picture: String? = ""
)
