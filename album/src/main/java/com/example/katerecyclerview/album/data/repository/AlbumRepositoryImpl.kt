package com.example.katerecyclerview.album.data.repository

import com.example.katerecyclerview.album.data.remote.AlbumRemoteSource
import com.example.katerecyclerview.album.domain.model.Album
import com.example.katerecyclerview.album.domain.repository.AlbumRepository

class AlbumRepositoryImpl(
    val remote: AlbumRemoteSource
): AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        val albums = remote.getAlbums()
        return albums
    }

    override suspend fun getAlbumById(id: Int): Album {
        val album = remote.getAlbumById(id)
        return album
    }

    override suspend fun createAlbum(album: Album): Album {
        val newAlbum = remote.createAlbum(album)
        return newAlbum
    }
}