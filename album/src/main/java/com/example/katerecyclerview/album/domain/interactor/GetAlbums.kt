package com.example.katerecyclerview.album.domain.interactor

import com.example.katerecyclerview.album.domain.model.Album
import com.example.katerecyclerview.album.domain.repository.AlbumRepository

class GetAlbums(val repository: AlbumRepository) {

    suspend operator fun invoke(): List<Album> {
        return repository.getAlbums()
    }
}