package com.example.katerecyclerview.post.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katerecyclerview.post.R
import kotlinx.android.synthetic.main.fragment_posts_main.*

class PostsMainFragment : Fragment() {
    lateinit var postController: PostController
    private val viewModelFactory: PostViewModelFactory by lazy { PostViewModelFactory() }
    private val viewModel: PostViewModel by viewModels() { viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initController()
        try {
            viewModel.loadData()
            viewModel.data.observe(viewLifecycleOwner){
                //display all posts in recyclerview
                postController.setNames(it)
            }
        } catch (e: Exception) {
            Toast.makeText(
                this.requireActivity(),
                "Exception Occurred: ${e.message}",
                Toast.LENGTH_SHORT
            ).show()
        }

        create_post.setOnClickListener{
            val action = PostsMainFragmentDirections.actionMainFragmentToCreatePostFragment()
            findNavController().navigate(action)
        }

        update_post.setOnClickListener{
            val action = PostsMainFragmentDirections.actionMainFragmentToUpdatePostFragment()
            findNavController().navigate(action)
        }

    }


    fun initController() {
        val clickListener: (View, Int) -> Unit = { view, id ->
            viewModel.loadDataById(id)
            viewModel.post.observe(viewLifecycleOwner){
                //pass post title and body to next fragment for display
                val title = it.title
                val body = it.body
                val action = PostsMainFragmentDirections.actionMainFragmentToPostFragment(title, body)
                findNavController().navigate(action)
            }
        }

        postController = PostController(clickListener)
        recycler_view.layoutManager = LinearLayoutManager(this.requireActivity())
        recycler_view.setControllerAndBuildModels(postController)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts_main, container, false)
    }


}