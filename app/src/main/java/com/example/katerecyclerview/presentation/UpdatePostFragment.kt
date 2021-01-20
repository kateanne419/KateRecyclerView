package com.example.katerecyclerview.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.katerecyclerview.R
import com.example.katerecyclerview.domain.model.Post
import kotlinx.android.synthetic.main.fragment_create_post.*
import kotlinx.android.synthetic.main.fragment_update_post.*


class UpdatePostFragment : Fragment() {

    private val viewModelFactory: MainViewModelFactory by lazy { MainViewModelFactory() }
    private val viewModel: MainViewModel by viewModels() { viewModelFactory}

    val args: UpdatePostFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit_update.setOnClickListener{
            try {

                viewModel.updateData(Integer.parseInt(edt_update_id.text.toString()),
                    Post(1, Integer.parseInt(edt_update_id.text.toString()), "title", edt_update_body.text.toString()))
                viewModel.updatedPost.observe(viewLifecycleOwner){
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

        val view =  inflater.inflate(R.layout.fragment_update_post, container, false)

        view.findViewById<TextView>(R.id.update_body).text = args.body
        return view


    }
}