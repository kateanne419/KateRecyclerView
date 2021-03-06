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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initController()
        try {
            viewModel.loadData()
            viewModel.data.observe(viewLifecycleOwner){
                nameController.setNames(it)

            }

        } catch (e: Exception) {
            Toast.makeText(
                    this.requireActivity(),
                    "Exception Occurred: ${e.message}",
                    Toast.LENGTH_SHORT
            ).show()
        }

    }

    fun initController() {


        val clickListener: (View, Int) -> Unit = { view, id ->
            viewModel.loadDataById(id)
            viewModel.post.observe(viewLifecycleOwner){
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}