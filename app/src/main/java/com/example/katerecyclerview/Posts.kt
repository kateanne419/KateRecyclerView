package com.example.katerecyclerview

import kotlinx.serialization.Serializable

@Serializable
data class Posts (
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
){
}