package com.example.katerecyclerview.domain.interactor

import com.example.katerecyclerview.domain.model.Post
import com.example.katerecyclerview.domain.repository.PostRepository

class GetPostById(val repository: PostRepository) {

    suspend operator fun invoke(id: Int): Post {
        return repository.getPostById(id)
    }
}