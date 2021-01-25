package com.example.katerecyclerview.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(layoutId: Int): AppCompatActivity(layoutId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start()
    }

    protected abstract fun start()
}