package com.example.katerecyclerview.album.domain

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val userId: Int,
    val id: Int,
    val title: String
) {
}