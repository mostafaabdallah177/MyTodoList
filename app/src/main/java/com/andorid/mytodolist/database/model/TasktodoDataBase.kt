package com.andorid.mytodolist.database.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [TasksDao::class],version = 1,exportSchema = false)
abstract class TasktodoDataBase :RoomDatabase() {
  abstract  fun tasksDao():TasksDao

  companion object{
      private var todoDataBase:TasktodoDataBase?=null

        fun getInstance(context:Context):TasktodoDataBase {
            if (todoDataBase == null) {
        todoDataBase=Room.databaseBuilder(context,TasktodoDataBase::class.java,"Todo-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            }
            return todoDataBase!!
        }
  }
}