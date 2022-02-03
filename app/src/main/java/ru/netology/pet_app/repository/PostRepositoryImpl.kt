package ru.netology.pet_app.repository

import ru.netology.pet_app.dao.TaskDao


class PostRepositoryImpl(private val dao: TaskDao) : PostRepository {
/* p1... = p - профильный уровень, 1 - номер задачи*/


    override fun getMessageById(id: Int): String? {
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