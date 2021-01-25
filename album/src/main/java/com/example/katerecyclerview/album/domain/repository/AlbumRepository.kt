package com.example.katerecyclerview.album.domain.repository

import com.example.katerecyclerview.album.domain.model.Album

interface AlbumRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbumById(id: Int): Album
    suspend fun createAlbum(album: Album): Album
}