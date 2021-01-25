package com.example.katerecyclerview.album.domain.interactor

import com.example.katerecyclerview.album.domain.model.Album
import com.example.katerecyclerview.album.domain.repository.AlbumRepository

class CreateAlbum(val repository: AlbumRepository) {

    suspend operator fun invoke(album: Album): Album {
        return repository.createAlbum(album)
    }
}