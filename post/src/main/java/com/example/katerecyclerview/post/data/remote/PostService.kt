package com.example.katerecyclerview.post.data.remote

import com.example.katerecyclerview.post.domain.model.Post
import retrofit2.Response
import retrofit2.http.*

interface PostService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("/posts/{id}")
    suspend fun getPostById(
        @Path("id") id: Int
    ): Response<Post>

    @POST("/posts")
    suspend fun createPost(
            @Body body: Post
    ): Response<Post>

    @PUT("/posts/{id}")
    suspend fun updatePost(
            @Path("id") id: Int, @Body body: Post
    ): Response<Post>
}