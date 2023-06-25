package com.halil.todolist.ViewModalFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.halil.todolist.ViewModal.ToDoListAddViewModal
import com.halil.todolist.ViewModal.ToDoListListViewModal

class ToDoListFactory(
    var context: Context
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ToDoListListViewModal(context) as T

}