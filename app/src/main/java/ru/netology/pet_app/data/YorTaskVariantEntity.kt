package ru.netology.pet_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class YorTaskVariantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: Int,
    val message: String,
    val answer: String,
    val yourAnswer: String? = null,
    val picture: Int? = null,
    val decided: Int
) {
    fun toDto() = YorTaskVariant(id, type, message, answer, yourAnswer, picture, decided)

    companion object {
        fun fromDto(task: YorTaskVariant) = with(task) {
            YorTaskVariantEntity(id, type, message, answer, yourAnswer, picture, decided)
        }
    }
}

