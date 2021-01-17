package com.example.katerecyclerview

import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity(layoutId : Int) : AppCompatActivity(layoutId){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start()
    }

    protected abstract fun start()
}