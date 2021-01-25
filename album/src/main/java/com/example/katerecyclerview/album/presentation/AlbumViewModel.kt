package com.example.katerecyclerview.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katerecyclerview.album.AlbumServiceLocator
import com.example.katerecyclerview.album.domain.Album
import com.example.katerecyclerview.album.domain.CreateAlbum
import com.example.katerecyclerview.album.domain.GetAlbumById
import com.example.katerecyclerview.album.domain.GetAlbums
import kotlinx.coroutines.launch

class AlbumViewModel(
    val getAlbums: GetAlbums,
    val getAlbumById: GetAlbumById,
    val createAlbum: CreateAlbum
): ViewModel() {

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>>
        get() = _albums

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album>
        get() = _album

    private val _newAlbum = MutableLiveData<Album>()
    val newAlbum: LiveData<Album>
        get() = _newAlbum

    fun loadAlbums(){
        viewModelScope.launch {
            _albums.value = getAlbums()
        }
    }

    fun loadDataById(id: Int){
        viewModelScope.launch {
            _album.value = getAlbumById(id)
        }
    }

    fun pushData(album: Album){
        viewModelScope.launch{
            _newAlbum.value = createAlbum(album)
        }
    }

    companion object{
        fun create() = AlbumViewModel(AlbumServiceLocator.getAlbums, AlbumServiceLocator.getAlbumById, AlbumServiceLocator.createAlbum)
    }
}