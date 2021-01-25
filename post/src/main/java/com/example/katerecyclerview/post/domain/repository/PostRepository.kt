package com.example.katerecyclerview.post.domain.repository

import com.example.katerecyclerview.post.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostById(id: Int): Post
    suspend fun createPost(post: Post): Post
    suspend fun updatePost(id: Int, post: Post): Post
}