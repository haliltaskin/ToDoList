package com.halil.todolist.view

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.halil.todolist.Modal.ToDoList
import com.halil.todolist.ViewModal.ToDoListAddViewModal
import com.halil.todolist.ViewModalFactory.ToDoAddFactory
import java.sql.Timestamp
import java.time.Instant
import java.time.format.DateTimeFormatter


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListAdd(navController: NavController){

    val tf_ToDo=remember{ mutableStateOf("") }

    val context= LocalContext.current as Activity
    val viewModal:ToDoListAddViewModal= viewModel(factory = ToDoAddFactory(context))

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    , verticalArrangement = Arrangement.SpaceEvenly
                    , horizontalAlignment = Alignment.CenterHorizontally
            ) {
                
                TextField(
                    value = tf_ToDo.value, 
                    onValueChange = {tf_ToDo.value=it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 25.dp)
                    , label = {
                        Text(text ="To Do")
                    }

                )


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 25.dp)
                    ,onClick = {
                        if(tf_ToDo.value!=null){
                            var toDoList=ToDoList(tf_ToDo.value)
                            viewModal.addToDo(toDoList)
                        }
                    
                }) {
                    Text(text = "Ekle")
                }
                
            }

        }
    )



}