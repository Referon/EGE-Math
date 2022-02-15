package ru.netology.pet_app.repository

import androidx.lifecycle.LiveData
import ru.netology.pet_app.data.YorTaskVariant


interface PostRepository {

    fun getIdVariant(typeV: Int): Int
    fun getAnswerVariantById(id: Int): String
    fun getMessageVariantById(id: Int): String
    fun getPictureVariantById(id: Int): String
    fun setDecidedVariantById(id: Int)
    fun removeDecidedVariant(typeV: Int)




    //    fun getMessageByIdVariant(id: Int): String
    //YorVariantTask
    fun deleteVariant()
    fun getTaskVariant(): LiveData<List<YorTaskVariant>>
    fun saveTaskVariant(task: YorTaskVariant)
    fun sizeSaveTask(): Int

    //TaskEntity
    fun getAnswerById(id: Int): String
    fun getMessageById(id: Int): String
    fun getId(type: Int): Int
    fun getSize(type: Int): Int
    fun getPictureById(id: Int): String
    fun setDecidedByID(id: Int)
    fun resetAllDecided()
}