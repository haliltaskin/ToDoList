package com.halil.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.halil.todolist.Modal.Pages
import com.halil.todolist.ui.theme.ToDoListTheme
import com.halil.todolist.view.ToDoList
import com.halil.todolist.view.ToDoListAdd

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoListTheme {
        App()
    }
}


@Composable
fun App() {

    val navController= rememberNavController()

    NavHost(navController =navController , startDestination = Pages.ToDoList.name){

        composable(route = Pages.ToDoList.name){
            ToDoList(navController)
        }

        composable(route = Pages.ToDoListAdd.name){
            ToDoListAdd(navController)
        }

    }

}




















