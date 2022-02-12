package ru.netology.pet_app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.data.YorTaskVariantEntity
import ru.netology.pet_app.dao.TaskDao


class PostRepositoryImpl(private val dao: TaskDao) : PostRepository {
/* p1... = p - профильный уровень, 1 - номер задачи*/


    override fun getIdVariant(typeV: Int): Int = dao.getIdVariant(typeV)


    override fun getAnswerVariantById(id: Int): String = dao.getAnswerVariantById(id)


    override fun getMessageVariantById(id: Int): String = dao.getMessageVariantById(id)

    override fun getPictureVariantById(id: Int): String = dao.getPictureVariantById(id)

    override fun setDecidedVariantById(id: Int) {
        dao.setDecidedVariantById(id)
    }

    override fun removeDecidedVariant(typeV: Int) {
        dao.removeDecidedVariant(typeV)
    }

    //YorVariantTask

    override fun saveTaskVariant(task: YorTaskVariant) {
        dao.saveVariant(YorTaskVariantEntity.fromDto(task))
    }

    override fun deleteVariant() {
        dao.deleteVariant()
    }

    override fun getTaskVariant(): LiveData<List<YorTaskVariant>> {
        return dao.getTaskVariant().map { task -> task.map { it.toDto() } }
    }

    override fun sizeSaveTask(): Int = dao.sizeSaveTask()


    //TaskEntity

    override fun getPictureById(id: Int): Int {
        return dao.getPictureById(id)
    }


    override fun getMessageById(id: Int): String {
        return dao.getMessageById(id).toString()
    }

    override fun getId(): Int {
        return dao.getId()
    }

    override fun setDecidedByID(id: Int) {
        dao.setDecidedById(id)
    }

    override fun getSize(): Int {
        return dao.getSize()
    }

    override fun getAnswerById(id: Int): String {
        return dao.getAnswerById(id).toString()
    }

    override fun resetAllDecided() {
        dao.resetAllDecided()
    }

}