package ru.netology.pet_app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.netology.pet_app.data.YorTaskVariantEntity

@Dao
interface TaskDao {

    @Query("SELECT picture FROM TaskVariantEntity WHERE id = :id")
    fun getPictureVariantById(id: Int): String

    @Query("SELECT message FROM TaskVariantEntity WHERE id = :id")
    fun getMessageVariantById(id: Int): String

    @Query("SELECT answer FROM TaskVariantEntity WHERE id = :id")
    fun getAnswerVariantById(id: Int): String

    @Query("SELECT id FROM TaskVariantEntity WHERE type = :typeV AND decided = 0")
    fun getIdVariant(typeV: Int): Int

    @Query("UPDATE TaskVariantEntity SET decided = 1 WHERE id = :id")
    fun setDecidedVariantById(id: Int)

    @Query("UPDATE TaskVariantEntity SET decided = 0 WHERE type = :typeV")
    fun removeDecidedVariant(typeV: Int)



    //YorTaskVariant

    @Insert
    fun insert(post: YorTaskVariantEntity)

    fun saveVariant(task: YorTaskVariantEntity) = insert(task)

    @Query("DELETE FROM YorTaskVariantEntity")
    fun deleteVariant()

    @Query("SELECT * FROM YorTaskVariantEntity ORDER BY id")
    fun getTaskVariant(): LiveData<List<YorTaskVariantEntity>>

    @Query("SELECT COUNT(id) FROM YorTaskVariantEntity")
    fun sizeSaveTask(): Int


    //TaskEntity

    @Query("SELECT id FROM TaskEntity WHERE decided = 0 AND type = :type ORDER BY random()")
    fun getId(type: Int): Int

    @Query("SELECT message FROM TaskEntity WHERE id = :id")
    fun getMessageById(id: Int): String

    @Query("SELECT answer FROM TaskEntity WHERE id = :id")
    fun getAnswerById(id: Int): String

    @Query("SELECT COUNT(id) FROM TaskEntity WHERE decided = 0 AND type = :type")
    fun getSize(type: Int): Int

    @Query("UPDATE TaskEntity SET decided = 1 WHERE id = :id")
    fun setDecidedById(id: Int)

    @Query("UPDATE TaskEntity SET decided = 0")
    fun resetAllDecided()

    @Query("SELECT picture FROM TaskEntity WHERE id = :id")
    fun getPictureById(id: Int): String

}