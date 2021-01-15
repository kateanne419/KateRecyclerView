package com.example.katerecyclerview

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : BaseActivity(R.layout.activity_main) {
    lateinit var nameController: NameController
    private val scope = MainScope()
    private val viewModel: NetworkViewModel by viewModels()

    override fun start() {
        initController()
        viewModel.loadData()
        viewModel.data.observe(this){
            nameController.setNames(it)
        }


        get_post.setOnClickListener {
            val id = single_post_id.text.toString()
            viewModel.loadDataById(Integer.parseInt(id))
            viewModel.post.observe(this){
                display_post.text = it.toString();
            }
            //doesnt have exception handling
        }
    }

    fun initController() {
        nameController = NameController()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setControllerAndBuildModels(nameController)
    }

}