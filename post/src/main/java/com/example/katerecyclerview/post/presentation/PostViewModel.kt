package com.example.katerecyclerview.post.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katerecyclerview.post.PostServiceLocator
import com.example.katerecyclerview.post.domain.interactor.CreatePost
import com.example.katerecyclerview.post.domain.interactor.GetPostById
import com.example.katerecyclerview.post.domain.interactor.GetPosts
import com.example.katerecyclerview.post.domain.interactor.UpdatePost
import com.example.katerecyclerview.post.domain.model.Post
import kotlinx.coroutines.launch

class PostViewModel(
    val getPosts: GetPosts,
    val getPostById: GetPostById,
    val createPost: CreatePost,
    val updatePost: UpdatePost
): ViewModel() {

    private val _data = MutableLiveData<List<Post>>()
    val data: LiveData<List<Post>>
        get() = _data

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post>
        get() = _post

    private val _newPost = MutableLiveData<Post>()
    val newPost: LiveData<Post>
        get() = _newPost

    private val _updatedPost = MutableLiveData<Post>()
    val updatedPost: LiveData<Post>
        get() = _updatedPost

    //call these sa main activity then use "it"
    fun loadData(){
        viewModelScope.launch {
            _data.value = getPosts()
        }
    }

    fun loadDataById(id: Int){
        viewModelScope.launch {
            _post.value = getPostById(id)
        }
    }

    fun pushData(post: Post){
        viewModelScope.launch{
            _newPost.value = createPost(post)
        }
    }

    fun updateData(id:  Int, post: Post){
        viewModelScope.launch{
            _updatedPost.value = updatePost(id, post)
        }
    }

    companion object {
        fun create() = PostViewModel(PostServiceLocator.getPosts, PostServiceLocator.getPostById, PostServiceLocator.createPost, PostServiceLocator.updatePost)
    }




}