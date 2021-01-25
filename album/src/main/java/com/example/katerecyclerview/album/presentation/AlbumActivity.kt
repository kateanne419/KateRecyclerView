package com.example.katerecyclerview.album.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.katerecyclerview.album.R
import com.example.katerecyclerview.common.BaseActivity

class AlbumActivity : BaseActivity(R.layout.activity_album) {

    override fun start() {

    }

    companion object {
        fun newIntent(context: Context) = Intent(context, AlbumActivity::class.java)
    }

}