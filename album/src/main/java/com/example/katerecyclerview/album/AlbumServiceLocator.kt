package com.example.katerecyclerview.album

import com.example.katerecyclerview.album.data.remote.AlbumRemoteSource
import com.example.katerecyclerview.album.data.repository.AlbumRepositoryImpl
import com.example.katerecyclerview.album.data.remote.AlbumService
import com.example.katerecyclerview.album.domain.interactor.CreateAlbum
import com.example.katerecyclerview.album.domain.interactor.GetAlbumById
import com.example.katerecyclerview.album.domain.interactor.GetAlbums
import com.example.katerecyclerview.common.CommonServiceLocator
import retrofit2.create

object AlbumServiceLocator {

    private val albumService: AlbumService = CommonServiceLocator.service.create()
    private val albumRemoteSource = AlbumRemoteSource(albumService)
    private val albumRepository = AlbumRepositoryImpl(albumRemoteSource)

    val getAlbums = GetAlbums(albumRepository)
    val getAlbumById = GetAlbumById(albumRepository)
    val createAlbum = CreateAlbum(albumRepository)
}