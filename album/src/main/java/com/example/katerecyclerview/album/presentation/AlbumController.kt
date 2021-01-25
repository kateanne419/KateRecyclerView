package com.example.katerecyclerview.album.presentation

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.example.katerecyclerview.album.AlbumItemModel_
import com.example.katerecyclerview.album.R
import com.example.katerecyclerview.album.domain.model.Album

class AlbumController(private val listener: (View, Int) -> Unit): EpoxyController() {
    var listOfTitles = mutableListOf<String>()
    var listOfUserIds = mutableListOf<Int>()
    var listOfAlbumIds = mutableListOf<Int>()
    var listOfPhotos = listOf(
        R.drawable.profile_1,
        R.drawable.profile_2,
        R.drawable.profile_3,
        R.drawable.profile_5,
        R.drawable.profile_4
    )
    var listOfColors = listOf(
        R.color.blue,
        R.color.yellow,
        R.color.orange,
        R.color.red,
        R.color.blue
    )

    override fun buildModels() {
        listOfTitles?.let{
            it.forEachIndexed { index, title ->
                listOfPhotos?.random()?.let { photo ->
                    listOfColors?.random()?.let { color ->
                        listOfAlbumIds?.get(index)?.let { albumId ->
                            listOfUserIds?.get(index)?.let { userId ->
                                AlbumItemModel_()
                                        .id(index)
                                        .title(title)
                                        .photo(photo)
                                        .color(color)
                                        .albumId(albumId)
                                        .userId(userId)
                                        .clickListener { model, _, view, _ ->
                                            listener.invoke(view, model.albumId())
                                        }
                                        .addTo(this)
                            }
                        }
                    }
                }
            }
        }
    }

    fun setNames(albums : List<Album>) {
        for (album in albums){
            listOfTitles.add(album.title)
            listOfUserIds.add(album.userId)
            listOfAlbumIds.add(album.id)
        }
        requestModelBuild()
    }

}