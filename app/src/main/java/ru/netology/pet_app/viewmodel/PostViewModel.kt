package ru.netology.pet_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.db.AppDb
import ru.netology.pet_app.repository.PostRepository
import ru.netology.pet_app.repository.PostRepositoryImpl

class PostViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PostRepository = PostRepositoryImpl(AppDb.getInstance(application).taskDao())




    fun getIdVariant(typeV: Int): Int = repository.getIdVariant(typeV)
    fun getAnswerVariantById(id: Int): String = repository.getAnswerVariantById(id)
    fun getMessageVariantById(id: Int): String = repository.getMessageVariantById(id)
    fun getPictureVariantById(id: Int): String = repository.getPictureVariantById(id)
    fun setDecidedVariantById(id: Int) = repository.setDecidedVariantById(id)
    fun removeDecidedVariant(typeV: Int) = repository.removeDecidedVariant(typeV)

    //YorVariantTask

    fun deleteVariant() = repository.deleteVariant()
    fun saveTaskVariant(task: YorTaskVariant) = repository.saveTaskVariant(task)
    fun sizeSaveTask(): Int = repository.sizeSaveTask()
    val data = repository.getTaskVariant()

    //TaskEntity
    fun getId(type: Int): Int = repository.getId(type)
    fun getMessageById(id: Int): String = repository.getMessageById(id)
    fun getAnswerById(id: Int): String = repository.getAnswerById(id)
    fun getPictureById(id: Int): String = repository.getPictureById(id)
    fun getSize(type: Int) = repository.getSize(type)
    fun setDecidedById(id: Int) = repository.setDecidedByID(id)
    fun resetAllDecided() = repository.resetAllDecided()
//    fun getTaskVariant():MutableList<YorTaskVariant> = repository.getTaskVariant()

    //Draft
    fun getDraftMessage():String = repository.getDraftMessage()
    fun deleteDraftMessage() = repository.deleteDraftMessage()
    fun saveDraftMEssage(message: String) = repository.saveDraftMEssage(message)
}