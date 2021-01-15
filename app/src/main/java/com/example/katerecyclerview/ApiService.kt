package com.example.katerecyclerview

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Posts>

    @GET("/posts/{id}")
    suspend fun getSinglePost(
            @Path("id") id: Int
    ): Posts


}