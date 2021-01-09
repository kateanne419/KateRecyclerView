package com.example.katerecyclerview

import android.graphics.Color.red
import android.graphics.drawable.Drawable
import com.airbnb.epoxy.EpoxyController
import kotlinx.coroutines.delay

class NameController : EpoxyController() {

    private var names : List<String>? = null
    private var infos : List<String>? = null
    private var photos : List<Int>? = null
    private var colors : List<Int>? = null

    override fun buildModels() {
        names?.let {
            it.forEachIndexed { index, name ->
                infos?.get(index)?.let { info ->
                    photos?.get(index)?.let { photo ->
                        colors?.get(index)?.let { color ->
                            NameItemModel_()
                                    .id(index)
                                    .name(name)
                                    .info(info)
                                    .photo(photo)
                                    .color(color)
                                    .ranking(index+1)
                                    .addTo(this)
                        }
                    }
                }
            }
        }
    }

    fun setNames(name : List<String>, info : List<String>, photo : List<Int>, color : List<Int>) {
        names = name
        infos = info
        photos = photo
        colors = color
        requestModelBuild()
    }


}