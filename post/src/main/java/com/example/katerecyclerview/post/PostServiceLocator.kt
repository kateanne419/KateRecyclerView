package com.example.katerecyclerview.post

import com.example.katerecyclerview.common.CommonServiceLocator
import com.example.katerecyclerview.post.data.cache.PostCacheSource
import com.example.katerecyclerview.post.data.remote.PostRemoteSource
import com.example.katerecyclerview.post.data.remote.PostService
import com.example.katerecyclerview.post.data.repository.PostRepositoryImpl
import com.example.katerecyclerview.post.domain.interactor.CreatePost
import com.example.katerecyclerview.post.domain.interactor.GetPostById
import com.example.katerecyclerview.post.domain.interactor.GetPosts
import com.example.katerecyclerview.post.domain.interactor.UpdatePost
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object PostServiceLocator {
    private val postService: PostService = CommonServiceLocator.service.create()
    private val postRemoteSource = PostRemoteSource(postService)
    private val postCacheSource = PostCacheSource()
    private val postRepository = PostRepositoryImpl(postRemoteSource, postCacheSource)



    val getPosts = GetPosts(postRepository)
    val getPostById = GetPostById(postRepository)
    val createPost = CreatePost(postRepository)
    val updatePost = UpdatePost(postRepository)
}