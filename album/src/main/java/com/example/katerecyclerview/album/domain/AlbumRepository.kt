package com.example.katerecyclerview.album.domain

interface AlbumRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbumById(id: Int): Album
    suspend fun createAlbum(album: Album): Album
}