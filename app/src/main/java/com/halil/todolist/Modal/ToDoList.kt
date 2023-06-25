package com.halil.todolist.Modal

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "ToDoList")
data class ToDoList(
    var toDo:String,


    @PrimaryKey(autoGenerate = true)
    var id:Int=0
)
