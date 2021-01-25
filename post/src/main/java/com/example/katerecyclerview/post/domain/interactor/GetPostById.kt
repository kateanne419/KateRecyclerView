package com.example.katerecyclerview.post.domain.interactor

import com.example.katerecyclerview.post.domain.model.Post
import com.example.katerecyclerview.post.domain.repository.PostRepository

class GetPostById(val repository: PostRepository) {

    suspend operator fun invoke(id: Int): Post {
        return repository.getPostById(id)
    }
}