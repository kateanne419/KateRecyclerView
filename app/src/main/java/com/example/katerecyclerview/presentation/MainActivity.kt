package com.example.katerecyclerview.presentation

import android.widget.Button
import com.example.katerecyclerview.R
import com.example.katerecyclerview.album.presentation.AlbumActivity
import com.example.katerecyclerview.common.BaseActivity
import com.example.katerecyclerview.post.presentation.PostActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {
    override fun start() {

        findViewById<Button>(R.id.btn_posts).setOnClickListener {
            startActivity(PostActivity.newIntent(this))
        }

        findViewById<Button>(R.id.btn_albums).setOnClickListener {
            startActivity(AlbumActivity.newIntent(this))
        }
    }
}