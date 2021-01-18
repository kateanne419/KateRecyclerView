package com.example.katerecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    lateinit var nameController: NameController
    private val viewModel: NetworkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initController()
        try {
            viewModel.loadData()
            viewModel.data.observe(viewLifecycleOwner){
                //display all posts in recyclerview
                nameController.setNames(it)
            }
        } catch (e: Exception) {
            Toast.makeText(
                    this.requireActivity(),
                    "Exception Occurred: ${e.message}",
                    Toast.LENGTH_SHORT
            ).show()
        }

        //create new button for creating posts, include edittext
        create_post.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToCreatePostFragment()
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
                val action = MainFragmentDirections.actionMainFragmentToPostFragment(title, body)
                findNavController().navigate(action)
            }
        }

        nameController = NameController(clickListener)
        recycler_view.layoutManager = LinearLayoutManager(this.requireActivity())
        recycler_view.setControllerAndBuildModels(nameController)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}