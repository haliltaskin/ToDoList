package com.halil.todolist.Repository

import com.halil.todolist.Dao.DaoToDo
import com.halil.todolist.Modal.ToDoList

class RoomRepository(private val dao: DaoToDo) {

    suspend fun listAllToDo():List<ToDoList>{
        return dao.listAllToDo()
    }

    suspend fun deleteToDo(toDoList: ToDoList){
         dao.deleteToDo(toDoList)
    }

    suspend fun insertToDo(toDoList: ToDoList){
        dao.insertToDo(toDoList)
    }
}