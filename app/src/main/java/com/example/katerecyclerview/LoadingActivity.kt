package com.example.katerecyclerview

import android.content.Intent
import android.os.Handler



class LoadingActivity : BaseActivity(R.layout.progress_bar) {

    override fun start() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)

    }

}