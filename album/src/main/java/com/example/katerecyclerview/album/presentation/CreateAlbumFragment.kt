package com.example.katerecyclerview.album.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.katerecyclerview.album.R
import com.example.katerecyclerview.album.domain.model.Album
import kotlinx.android.synthetic.main.fragment_create_album.*

class CreateAlbumFragment : Fragment() {

    private val viewModelFactory: AlbumViewModelFactory by lazy { AlbumViewModelFactory() }
    private val viewModel: AlbumViewModel by viewModels() {viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit_album.setOnClickListener{
            try{

                val myAlbum = Album(Integer.parseInt(edt_user_id.text.toString()),
                        Integer.parseInt(edt_album_id.text.toString()),
                        edt_album_title.text.toString())
                viewModel.pushData(myAlbum)
                viewModel.newAlbum.observe(viewLifecycleOwner){
                    Toast.makeText(
                            this.requireActivity(),
                            it.toString(),
                            Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(
                        this.requireActivity(),
                        "Exception Occurred: ${e.message}",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_album, container, false)
    }
}