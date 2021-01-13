package com.example.katerecyclerview

import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostActivity : BaseActivity(R.layout.activity_post) {
    private val scope = MainScope()

    override fun start() {
        scope.launch {
            try {
//                loadData()
            } catch (e: Exception) {
                Toast.makeText(
                        this@PostActivity,
                        "Exception Occurred: ${e.message}",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


//    private suspend fun loadData() {
//        val post = withContext(Dispatchers.IO){ getSinglePost() }
//        post_body.text = post.toString()
//        //display to textview
//    }

//    private suspend fun getSinglePost(): SinglePost? {
//        val response = ApiClient.client.getSinglePost()
//        Log.v("this is a singpost res", response.toString())
//        return response.body()
//    }

}