package com.example.katerecyclerview.album.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katerecyclerview.album.AlbumController
import com.example.katerecyclerview.album.R
import kotlinx.android.synthetic.main.fragment_albums_main.*

class AlbumsMainFragment : Fragment() {

    lateinit var albumController: AlbumController
    private val viewModelFactory: AlbumViewModelFactory by lazy { AlbumViewModelFactory() }
    private val viewModel: AlbumViewModel by viewModels() { viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initController()
        try {
            viewModel.loadAlbums()
            viewModel.albums.observe(viewLifecycleOwner){
                //display all posts in recyclerview
                albumController.setNames(it)
            }
        } catch (e: Exception) {
            Toast.makeText(
                    this.requireActivity(),
                    "Exception Occurred: ${e.message}",
                    Toast.LENGTH_SHORT
            ).show()
        }

        create_album.setOnClickListener{
            val action = AlbumsMainFragmentDirections.actionAlbumsMainFragmentToCreateAlbumFragment()
            findNavController().navigate(action)
        }

        update_album.setOnClickListener{
            val action = AlbumsMainFragmentDirections.actionAlbumsMainFragmentToUpdateAlbumFragment()
            findNavController().navigate(action)
        }

    }

    fun initController() {
        val clickListener: (View, Int) -> Unit = { view, id ->
            viewModel.loadDataById(id)
            viewModel.album.observe(viewLifecycleOwner){
                val title = it.title
                val action = AlbumsMainFragmentDirections.actionAlbumsMainFragmentToAlbumFragment(title)
                findNavController().navigate(action)
            }

        }

        albumController = AlbumController(clickListener)
        recycler_view.layoutManager = LinearLayoutManager(this.requireActivity())
        recycler_view.setControllerAndBuildModels(albumController)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums_main, container, false)
    }

}