package ru.netology.pet_app.data

data class YorTaskVariant(
    val id: Int,
    val type: Int,
    val message: String,
    val answer: String,
    val yourAnswer: String? = null,
    val picture: String? = "",
    val decided: Int
)
