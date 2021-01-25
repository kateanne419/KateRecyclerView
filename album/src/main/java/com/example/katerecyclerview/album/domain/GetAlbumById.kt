package com.example.katerecyclerview.album.domain

class GetAlbumById(val repository: AlbumRepository) {

    suspend operator fun invoke(id: Int): Album {
        return repository.getAlbumById(id)
    }
}