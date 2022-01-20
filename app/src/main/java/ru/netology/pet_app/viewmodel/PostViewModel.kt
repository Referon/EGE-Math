package ru.netology.pet_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import ru.netology.pet_app.db.AppDb
import ru.netology.pet_app.repository.PostRepository
import ru.netology.pet_app.repository.PostRepositoryImpl

class PostViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PostRepository = PostRepositoryImpl(AppDb.getInstance(application).taskDao())

    fun getMessageById(id: Int): String? = repository.getMessageById(id)
    fun getAnswerById(id: Int): String = repository.getAnswerById(id)
    fun getId(): Int = repository.getId()
    fun getSize() = repository.getSize()
    fun setDecidedById(id: Int) = repository.setDecidedByID(id)
}