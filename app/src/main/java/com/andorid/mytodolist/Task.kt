package com.andorid.mytodolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity
 data class Task (
    @ColumnInfo  @PrimaryKey(autoGenerate = true) var id :Int?=null,
    @ColumnInfo  var titleTask: String?=null,
    @ColumnInfo  var DescripitonTask:String?=null,
    @ColumnInfo  var IsCompletedTask:Boolean?=false

):Serializable