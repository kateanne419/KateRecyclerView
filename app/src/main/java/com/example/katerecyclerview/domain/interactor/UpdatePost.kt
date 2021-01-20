package com.example.katerecyclerview.domain.interactor

import com.example.katerecyclerview.domain.model.Post
import com.example.katerecyclerview.domain.repository.PostRepository

class UpdatePost(val repository: PostRepository) {

    suspend operator fun invoke(id: Int, post: Post): Post{
        return repository.updatePost(id, post)
    }
}