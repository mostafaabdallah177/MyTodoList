package com.andorid.mytodolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
 data class TaskTodo(
    @ColumnInfo  @PrimaryKey(autoGenerate = true) var id :Int?=null,
    @ColumnInfo  var title: String?=null,
    @ColumnInfo  var Descripiton:String?=null,
    @ColumnInfo  var IsCompleted:Boolean?=false
)