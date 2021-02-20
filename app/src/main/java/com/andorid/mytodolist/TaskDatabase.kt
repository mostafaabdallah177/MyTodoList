package com.andorid.mytodolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =  [Task::class],version = 1,exportSchema = false)
abstract class TaskDatabase() : RoomDatabase() {


    abstract fun tasksDao(): TasksDao

    companion object {
        private var dataBase: TaskDatabase? = null

        // de return al object database
        fun getInstance(context: Context): TaskDatabase {
            if (dataBase == null) {
                dataBase = Room.databaseBuilder(
                    context, TaskDatabase::class.java, "Todo-db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return dataBase!!
        }
    }

}