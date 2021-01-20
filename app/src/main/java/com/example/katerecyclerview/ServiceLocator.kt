package com.example.katerecyclerview

import com.example.katerecyclerview.data.cache.PostCacheSource
import com.example.katerecyclerview.data.remote.PostRemoteSource
import com.example.katerecyclerview.data.remote.PostService
import com.example.katerecyclerview.data.repository.PostRepositoryImpl
import com.example.katerecyclerview.domain.interactor.CreatePost
import com.example.katerecyclerview.domain.interactor.GetPostById
import com.example.katerecyclerview.domain.interactor.GetPosts
import com.example.katerecyclerview.domain.interactor.UpdatePost
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object ServiceLocator {
    // Logging Interceptor
    private val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    // OkHttp Instance
    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    // Retrofit Instance
    private val contentType = "application/json".toMediaType()
    private val service: PostService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(OkHttpClient())
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
            .create()

    private val postRemoteSource = PostRemoteSource(service)
    private val postCacheSource = PostCacheSource()
    private val postRepository = PostRepositoryImpl(postRemoteSource, postCacheSource)

    val getPosts = GetPosts(postRepository)
    val getPostById = GetPostById(postRepository)
    val createPost = CreatePost(postRepository)
    val updatePost = UpdatePost(postRepository)
}