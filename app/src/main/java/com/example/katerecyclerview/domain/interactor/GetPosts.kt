package com.example.katerecyclerview.domain.interactor

import com.example.katerecyclerview.domain.model.Post
import com.example.katerecyclerview.domain.repository.PostRepository

class GetPosts(val repository: PostRepository) {

    suspend operator fun invoke(): List<Post> {
        return repository.getPosts()
    }
}