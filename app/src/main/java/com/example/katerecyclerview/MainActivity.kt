package com.example.katerecyclerview

import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : BaseActivity(R.layout.activity_main) {
    private lateinit var nameController: NameController
    private val scope = MainScope()

    override fun start() {
        initController()
        scope.launch {
            try {
                loadData()
            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Exception Occurred: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun initController() {
        nameController = NameController()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setControllerAndBuildModels(nameController)
    }

    private fun addItems(postList: List<Posts>) {
        var listOfTitles = mutableListOf<String>()
        var listOfBodies = mutableListOf<String>()
        var listOfUserIds = mutableListOf<Int>()
        var listOfPostIds = mutableListOf<Int>()

        for (post in postList){
            listOfTitles.add(post.title)
            listOfBodies.add(post.body)
            listOfUserIds.add(post.userId)
            listOfPostIds.add(post.id)
        }

        Log.v("list of titles", listOfTitles.toString())
        Log.v("list of bodies", listOfBodies.toString())

        var listOfPhotos = listOf(R.drawable.profile_1, R.drawable.profile_2, R.drawable.profile_3, R.drawable.profile_5, R.drawable.profile_4 )
        var listOfColors = listOf(R.color.blue, R.color.yellow, R.color.orange, R.color.red, R.color.blue)

        nameController.setNames(listOfTitles, listOfBodies, listOfUserIds, listOfPostIds, listOfPhotos, listOfColors)
    }


    private suspend fun loadData() {
        val post = withContext(Dispatchers.IO){ getPost() }
        addItems(post)
    }

    private suspend fun getPost(): List<Posts>{
        val response = ApiClient.client.getPosts()

        Log.v("this is the response", response.toString())

        if (response != null) {
            return response
        } else {
            throw Exception(response[0].title)
        }
    }
}