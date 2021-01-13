package com.example.katerecyclerview

import android.util.Log
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

    fun loadData(){
        viewModelScope.launch {
            _data.value = getPost()
        }
    }

    private suspend fun getPost(): List<Posts> = withContext(Dispatchers.IO){
        val response = ApiClient.client.getPosts()

        if (response != null) {
            return@withContext response
        } else {
            throw Exception(response[0].title)
        }
    }
}