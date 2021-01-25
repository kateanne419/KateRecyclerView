package com.example.katerecyclerview.post.presentation

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.example.katerecyclerview.post.PostItemModel_
import com.example.katerecyclerview.post.R
import com.example.katerecyclerview.post.domain.model.Post

class PostController(private val listener: (View, Int) -> Unit) : EpoxyController() {
    var listOfTitles = mutableListOf<String>()
    var listOfBodies = mutableListOf<String>()
    var listOfUserIds = mutableListOf<Int>()
    var listOfPostIds = mutableListOf<Int>()
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
        listOfTitles?.let {
            it.forEachIndexed { index, title ->
                listOfBodies?.get(index)?.let { body ->
                    listOfPhotos?.random()?.let { photo ->
                        listOfColors?.random()?.let { color ->
                            listOfPostIds?.get(index)?.let { postId ->
                                listOfUserIds?.get(index)?.let {userId ->
                                    PostItemModel_()
                                        .id(index)
                                        .title(title)
                                        .body(body)
                                        .photo(photo)
                                        .color(color)
                                        .postId(postId)
                                        .userId(userId)
                                        .clickListener { model, _, view, _ ->
                                            listener.invoke(view, model.postId())
                                        }
                                        .addTo(this)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun setNames(posts : List<Post>) {
        for (post in posts){
            listOfTitles.add(post.title)
            listOfBodies.add(post.body)
            listOfUserIds.add(post.userId)
            listOfPostIds.add(post.id)
        }
        requestModelBuild()
    }



}