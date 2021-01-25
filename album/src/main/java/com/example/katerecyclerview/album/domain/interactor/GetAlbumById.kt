package com.example.katerecyclerview.album.domain.interactor

import com.example.katerecyclerview.album.domain.model.Album
import com.example.katerecyclerview.album.domain.repository.AlbumRepository

class GetAlbumById(val repository: AlbumRepository) {

    suspend operator fun invoke(id: Int): Album {
        return repository.getAlbumById(id)
    }
}