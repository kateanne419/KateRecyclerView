package com.example.katerecyclerview.album.domain

class GetAlbums(val repository: AlbumRepository) {

    suspend operator fun invoke(): List<Album> {
        return repository.getAlbums()
    }
}