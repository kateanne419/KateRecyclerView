package com.example.katerecyclerview

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NetworkViewModel: ViewModel() {

    private val _data = MutableLiveData<List<Posts>>()
    val data: LiveData<List<Posts>>
        get() = _data

    private val _post = MutableLiveData<Posts>()
    val post: LiveData<Posts>
        get() = _post

    private val _newPost = MutableLiveData<Posts>()
    val newPost: LiveData<Posts>
        get() = _newPost

    fun loadData(){
        viewModelScope.launch {
            _data.value = getPost()
        }
    }

    fun loadDataById(id: Int){
        viewModelScope.launch {
            _post.value = getPostById(id)
        }
    }

    fun pushData(post: Posts){
        viewModelScope.launch{
            _newPost.value = pushPost(post)
        }
    }

    private suspend fun getPost(): List<Posts> = withContext(Dispatchers.IO){
        val response = ApiClient.client.getPosts()
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return@withContext data
        } else {
            throw Exception(response.code().toString())
        }
    }

    private suspend fun getPostById(id: Int): Posts {
        val response = ApiClient.client.getSinglePost(id)
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }
    }

    private suspend fun pushPost(post: Posts): Posts {
        val response = ApiClient.client.createPost(post)
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }

    }
}