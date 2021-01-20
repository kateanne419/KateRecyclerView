package com.example.katerecyclerview.data.remote

import com.example.katerecyclerview.domain.model.Post

class PostRemoteSource(val service: PostService) {

    suspend fun getPosts(): List<Post> {
        val response = service.getPosts()
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }
    }

    suspend fun getPostById(id: Int): Post {
        val response = service.getPostById(id)
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }
    }

    suspend fun createPost(post: Post): Post {
        val response = service.createPost(post)
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }

    }

    suspend fun updatePost(id: Int, post: Post): Post {
        val response = service.updatePost(id, post)
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }

    }

}