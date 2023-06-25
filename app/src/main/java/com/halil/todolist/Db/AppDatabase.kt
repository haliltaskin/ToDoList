package com.halil.todolist.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.halil.todolist.Dao.DaoToDo
import com.halil.todolist.Modal.ToDoList


@Database(
    entities = [ToDoList::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {

    abstract fun dao():DaoToDo

    companion object{
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{

            var tmpInstance= INSTANCE
            if (tmpInstance != null){
                return tmpInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}