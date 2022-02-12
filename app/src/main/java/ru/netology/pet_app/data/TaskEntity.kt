package ru.netology.pet_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: Int,
    val message: String,
    val answer: String,
    val decided: Boolean,
    val picture: String? = ""
) {
    fun toDto() = Task(id, type, message, answer, decided, picture)

    companion object {
        fun fromDto(task: Task) = with(task) {
            TaskEntity(id, type, message, answer, decided, picture)
        }
    }
}
