package com.halil.todolist.ViewModal

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halil.todolist.Db.AppDatabase
import com.halil.todolist.Modal.ToDoList
import com.halil.todolist.Repository.RoomRepository
import kotlinx.coroutines.launch

class ToDoListListViewModal(
    context: Context
):ViewModel() {

    private lateinit var repository:RoomRepository

    init {
        viewModelScope.launch {
            val dao= AppDatabase.getDatabase(context).dao()
            repository= RoomRepository(dao)
        }
    }

    fun ListAllToDo(toDoList: ToDoList){
        viewModelScope.launch {
            repository.listAllToDo()
        }
    }

}