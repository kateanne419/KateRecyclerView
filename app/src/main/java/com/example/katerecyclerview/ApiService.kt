package com.example.katerecyclerview

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Posts>>

    @GET("/posts/{id}")
    suspend fun getSinglePost(
            @Path("id") id: Int
    ): Response<Posts>

//    @POST("/posts")
//    suspend fun createPost(@Body body: PostRequest): Response<Posts>

//    @PUT("/posts/{id}")
//    suspend fun updatePost(@Path("id") id: String, @Body body: PostRequest): Response<Posts>
}