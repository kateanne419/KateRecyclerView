package com.example.katerecyclerview

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : BaseActivity(R.layout.activity_main) {
    private lateinit var nameController: NameController
    private lateinit var toDoList: List<ToDo>


    override fun start() {
        //progressBar.visibility = GONE
        initController()
        runBlocking {
            toDoList = getToDo()
        }
        addItems(toDoList)

    }

    private fun initController() {

        nameController = NameController()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setControllerAndBuildModels(nameController)
    }

    private fun addItems(toDoList: List<ToDo>) {
        var listofNames = listOf(toDoList.get(0).name, toDoList.get(1).name, toDoList.get(2).name, toDoList.get(3).name)
        var listofToDo = listOf(toDoList.get(0).description, toDoList.get(1).description, toDoList.get(2).description, toDoList.get(3).description)
        var listOfPhotos = listOf(R.drawable.profile_1, R.drawable.profile_2, R.drawable.profile_3, R.drawable.profile_5, R.drawable.profile_4 )
        var listOfColors = listOf(R.color.blue, R.color.yellow, R.color.orange, R.color.red, R.color.blue)

        nameController.setNames(listofNames, listofToDo,  listOfPhotos, listOfColors)
    }


   private suspend fun getToDo(): List<ToDo> {
       delay(5000L)
        var todo = ToDo(
                "Karen",
                "Talk to the Manager"
        )

        var todo2 = ToDo(
                "Mike",
                "Buy Groceries"
        )

        var todo3 = ToDo(
                "John",
                "Do Laundry"
        )

           var todo4 = ToDo(
               "Jim",
               "Read a Book"
           )
       return listOf(todo, todo2, todo3, todo4)
    }

    data class ToDo(
            var name: String,
            var description: String
    )
}