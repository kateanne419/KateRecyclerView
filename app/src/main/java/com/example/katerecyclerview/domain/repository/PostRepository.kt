package com.example.katerecyclerview.domain.repository

import com.example.katerecyclerview.domain.model.Post

interface PostRepository {
    //function inits
    //to be overridden/implemented in postrepositoryimpl, the functions here are called in domain.interactors
    //bridge between data and domain

    suspend fun getPosts(): List<Post>
    suspend fun getPostById(id: Int): Post
    suspend fun createPost(post: Post): Post
    suspend fun updatePost(id: Int, post: Post): Post
}