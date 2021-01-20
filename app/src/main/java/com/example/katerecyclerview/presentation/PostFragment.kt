package com.example.katerecyclerview.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.katerecyclerview.R


class PostFragment : Fragment() {

    val args: PostFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        view.findViewById<TextView>(R.id.display_title).text = args.title
        view.findViewById<TextView>(R.id.display_body).text = args.body

        return view
    }


}