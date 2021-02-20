package com.andorid.mytodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andorid.mytodolist.database.TaskTodo
import com.andorid.mytodolist.database.model.TasksDao
import com.andorid.mytodolist.database.model.TasktodoDataBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TasktodoDataBase.getInstance(this)
            .tasksDao()
    }
}