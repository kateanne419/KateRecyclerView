package com.example.katerecyclerview.presentation

import android.content.Intent
import android.os.Handler
import com.example.katerecyclerview.R


class LoadingActivity : BaseActivity(R.layout.progress_bar) {

    override fun start() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)

    }

}