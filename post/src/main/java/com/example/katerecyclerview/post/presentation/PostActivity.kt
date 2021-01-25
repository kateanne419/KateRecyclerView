package com.example.katerecyclerview.post.presentation

import android.content.Context
import android.content.Intent
import com.example.katerecyclerview.common.BaseActivity

import com.example.katerecyclerview.post.R

class PostActivity : BaseActivity(R.layout.activity_post) {
    override fun start() {

    }

    companion object {
        fun newIntent(context: Context) = Intent(context, PostActivity::class.java)
    }
}