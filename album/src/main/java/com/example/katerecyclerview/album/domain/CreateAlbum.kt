package com.example.katerecyclerview.album.domain

class CreateAlbum(val repository: AlbumRepository) {

    suspend operator fun invoke(album: Album): Album {
        return repository.createAlbum(album)
    }
}