package com.halil.todolist.view

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.halil.todolist.Modal.Pages
import com.halil.todolist.Modal.ToDoList
import com.halil.todolist.R
import com.halil.todolist.ViewModal.ToDoListListViewModal
import com.halil.todolist.ViewModalFactory.ToDoListFactory


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoList(navController: NavController){

    val colorList= listOf<Color>(
        Color(0xFF3AA6B9),
        Color(0xFFFFD0D0),
        Color(0xFFFF9EAA),
        Color(0xFFC1ECE4)
    )


    val aramaYap= remember { mutableStateOf(false) }
    val tf_ara= remember { mutableStateOf("") }
    val context= LocalContext.current as Activity
    val viewModal:ToDoListListViewModal= viewModel(factory = ToDoListFactory(context))
  Scaffold(

      topBar = {
               TopAppBar(
                   title = {

                       if (aramaYap.value){
                           TextField(value = tf_ara.value,
                               onValueChange = {
                                   tf_ara.value=it
                               },
                               label = {
                                   Text(text = "Ara")
                               },
                               colors = TextFieldDefaults.textFieldColors(
                                   containerColor = Color.Transparent,
                                   focusedLabelColor = Color.White,
                                   focusedIndicatorColor = Color.White,
                                   unfocusedIndicatorColor = Color.White,
                               )
                           )
                       }else{
                           Text(text = "ToDoList")
                       }
                           },
                   colors = TopAppBarDefaults.smallTopAppBarColors(
                       containerColor = Color(0xFF3AA6B9)
                   ),

                   actions = {
                       if(aramaYap.value){

                           IconButton(onClick = {
                               aramaYap.value=false
                               tf_ara.value=""
                           }) {
                               Icon(painter = painterResource(id = R.drawable.close_jpg),
                                   contentDescription = "arama")
                           }

                       }else{
                           IconButton(onClick = {
                               aramaYap.value=true
                           }) {
                               Icon(painter = painterResource(id = R.drawable.search_jpg),
                                   contentDescription = "arama")
                           }
                       }
                   }
               )


      }


      ,content = {

          Box(
              modifier = Modifier.fillMaxSize()
          ){
              LazyColumn(){


              }





              FloatingActionButton(
                  modifier = Modifier
                      .align(Alignment.BottomEnd)
                      .padding(all = 20.dp)
                  ,onClick = {
                      navController.navigate(Pages.ToDoListAdd.name)
                  }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "Go to Add page")
              }

          }

      }
  )

}


@Composable
fun ToDoListItem(toDoList: ToDoList,color: Color){
    
    Column() {
        
    }
    
}

