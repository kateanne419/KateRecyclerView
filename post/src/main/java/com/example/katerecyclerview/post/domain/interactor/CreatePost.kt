package com.example.katerecyclerview.post.domain.interactor

import com.example.katerecyclerview.post.domain.model.Post
import com.example.katerecyclerview.post.domain.repository.PostRepository

class CreatePost(val repository: PostRepository) {

    suspend operator fun invoke(post: Post): Post {
        return repository.createPost(post)
    }
}