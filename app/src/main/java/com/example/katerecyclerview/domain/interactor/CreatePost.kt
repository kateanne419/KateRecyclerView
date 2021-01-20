package com.example.katerecyclerview.domain.interactor

import com.example.katerecyclerview.domain.model.Post
import com.example.katerecyclerview.domain.repository.PostRepository

class CreatePost(val repository: PostRepository) {

    suspend operator fun invoke(post: Post): Post {
        return repository.createPost(post)
    }
}