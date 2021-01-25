package com.example.katerecyclerview.album.data

import com.example.katerecyclerview.album.domain.Album
import com.example.katerecyclerview.album.domain.AlbumRepository

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