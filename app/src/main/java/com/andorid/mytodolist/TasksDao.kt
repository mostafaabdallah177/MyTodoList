package com.andorid.mytodolist

import androidx.room.*
@Dao
interface TasksDao{
    @Insert
    fun addTask(task: Task)
    @Update
    fun UpdatTask(task: Task)
    @Delete
    fun DeleteTask(task: Task)
    @Query("select *from Task")
    fun SelectAllTasks():List<Task>
    @Query("select *from Task Where titleTask Like :word or DescripitonTask Like :word")
    fun serchTask(word:String):List<Task>
}