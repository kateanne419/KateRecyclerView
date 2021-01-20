package com.example.katerecyclerview.data.repository

import com.example.katerecyclerview.data.cache.PostCacheSource
import com.example.katerecyclerview.data.remote.PostRemoteSource
import com.example.katerecyclerview.domain.interactor.GetPostById
import com.example.katerecyclerview.domain.model.Post
import com.example.katerecyclerview.domain.repository.PostRepository

class PostRepositoryImpl(
        val remote: PostRemoteSource,
        val cache: PostCacheSource
): PostRepository {

    override suspend fun getPosts(): List<Post> {
        if (cache.posts.isNotEmpty()){
            return cache.posts
        }

        val posts = remote.getPosts()
        cache.posts = posts
        return posts
    }

    override suspend fun getPostById(id: Int): Post {
        val post = remote.getPostById(id)
        return post
    }

    override suspend fun createPost(post: Post): Post {
        val newPost = remote.createPost(post)
        return newPost
    }

    override suspend fun updatePost(id: Int, post: Post): Post {
        val updatedPost = remote.updatePost(id, post)
        return updatedPost
    }


}
