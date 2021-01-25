package com.example.katerecyclerview.album.data

import com.example.katerecyclerview.album.domain.Album

class AlbumRemoteSource(val service: AlbumService) {
    suspend fun getAlbums(): List<Album> {
        val response = service.getAlbums()
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }
    }

    suspend fun getAlbumById(id: Int): Album{
        val response = service.getAlbumById(id)
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }
    }

    suspend fun createAlbum(album: Album): Album {
        val response = service.createAlbum(album)
        val data = response.body()

        if (response.isSuccessful && data!=null) {
            return data
        } else {
            throw Exception(response.code().toString())
        }
    }
}