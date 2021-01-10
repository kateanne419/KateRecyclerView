package com.example.katerecyclerview

import android.graphics.Color.red
import android.graphics.drawable.Drawable
import com.airbnb.epoxy.EpoxyController
import kotlinx.android.synthetic.main.item_name.view.*
import kotlinx.coroutines.delay

class NameController : EpoxyController() {

    private var titles : List<String>? = null
    private var bodies : List<String>? = null
    private var photos : List<Int>? = null
    private var colors : List<Int>? = null
    private var userIds : List<Int>? = null
    private var postIds : List<Int>? = null

    override fun buildModels() {
        titles?.let {
            it.forEachIndexed { index, title ->
                bodies?.get(index)?.let { body ->
                    photos?.random()?.let { photo ->
                        colors?.random()?.let { color ->
                            postIds?.get(index)?.let { postId ->
                                userIds?.get(index)?.let {userId ->
                                    NameItemModel_()
                                            .id(index)
                                            .title(title)
                                            .body(body)
                                            .photo(photo)
                                            .color(color)
                                            .postId(postId)
                                            .userId(userId)
                                            .addTo(this)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun setNames(title : List<String>, body : List<String>, userId : List<Int>, postId : List<Int>, photo : List<Int>, color : List<Int>) {
        titles = title
        bodies = body
        userIds = userId
        postIds = postId
        photos = photo
        colors = color
        requestModelBuild()
    }


}