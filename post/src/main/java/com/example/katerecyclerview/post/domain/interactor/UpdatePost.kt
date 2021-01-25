package com.example.katerecyclerview.post.domain.interactor

import com.example.katerecyclerview.post.domain.model.Post
import com.example.katerecyclerview.post.domain.repository.PostRepository

class UpdatePost(val repository: PostRepository) {

    suspend operator fun invoke(id: Int, post: Post): Post{
        return repository.updatePost(id, post)
    }
}