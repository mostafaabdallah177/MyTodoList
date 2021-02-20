package com.andorid.mytodolist.database.model

import androidx.room.*

@Dao
interface TasksDao{
    @Insert
    fun addTask(tasksDao: TasksDao)
    @Update
    fun UpdatTask(tasksDao: TasksDao)
    @Delete
    fun DeleteTask(tasksDao: TasksDao)
    @Query("select *from TaskTodo")
    fun SelectAllTasks():List<TasksDao>
    @Query("select *from TaskTodo Where title Like :word or Descripiton Like :word")
    fun serchTask(word:String):List<TasksDao>
}