package com.example.katerecyclerview.album.data.remote

import com.example.katerecyclerview.album.domain.model.Album
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("/albums/{id}")
    suspend fun getAlbumById(
            @Path("id") id:Int
    ): Response<Album>

    @POST("/albums")
    suspend fun createAlbum(
            @Body body: Album
    ): Response<Album>
}