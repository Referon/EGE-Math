package ru.netology.pet_app.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TaskDao {

    @Query("SELECT message FROM TaskEntity WHERE id = :id AND NOT decided = 1")
    fun getMessageById(id: Int): String?

    @Query("SELECT answer FROM TaskEntity WHERE id = :id AND NOT decided = 1")
    fun getAnswerById(id: Int): String

    @Query("SELECT id FROM TaskEntity WHERE decided = 0")
    fun getId(): Int

    @Query("SELECT COUNT(id) FROM TaskEntity WHERE decided = 0")
    fun getSize(): Int

    @Query("UPDATE TaskEntity SET decided = 1 WHERE id = :id")
    fun setDecidedById(id: Int)

}