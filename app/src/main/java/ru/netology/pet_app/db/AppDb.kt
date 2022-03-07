package ru.netology.pet_app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.netology.pet_app.dao.TaskDao
import ru.netology.pet_app.data.*

@Database(entities = [TaskEntity::class, YorTaskVariantEntity::class, TaskVariantEntity::class, DraftEntity::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object{
@Volatile
private var instance: AppDb? = null

        fun getInstance(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context, AppDb::class.java, "app.db")
            .allowMainThreadQueries()
            .createFromAsset("database/app.db")
            .build()
    }
}