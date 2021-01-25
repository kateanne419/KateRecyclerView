package com.example.katerecyclerview.post.domain.interactor

import com.example.katerecyclerview.post.domain.model.Post
import com.example.katerecyclerview.post.domain.repository.PostRepository

class GetPosts(val repository: PostRepository) {

    suspend operator fun invoke(): List<Post> {
        return repository.getPosts()
    }
}