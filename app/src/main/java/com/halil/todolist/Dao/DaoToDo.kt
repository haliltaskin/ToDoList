package com.halil.todolist.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.halil.todolist.Modal.ToDoList

@Dao
interface DaoToDo {

    @Query("SELECT * FROM TODOLIST ORDER BY id ASC")
    suspend fun listAllToDo():List<ToDoList>

    @Delete
    suspend fun deleteToDo(toDoList: ToDoList)

    @Insert
    suspend fun insertToDo(toDoList: ToDoList)


}