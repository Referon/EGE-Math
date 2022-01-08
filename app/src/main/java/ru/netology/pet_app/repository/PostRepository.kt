package ru.netology.pet_app.repository


interface PostRepository {

    fun getAnswerById(id: Int): String
    fun getMessageById(id: Int): String?
    fun getId(): Int
    fun getSize(): Int
    fun setDecidedByID(id: Int)
}