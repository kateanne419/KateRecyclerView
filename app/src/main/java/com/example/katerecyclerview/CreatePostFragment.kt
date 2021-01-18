package com.example.katerecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_create_post.*


/**
 * A simple [Fragment] subclass.
 * Use the [CreatePostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreatePostFragment : Fragment() {

    private val viewModel: NetworkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit_post.setOnClickListener{
            try {

                val myPost = Posts(Integer.parseInt(edt_user_id.text.toString()) , Integer.parseInt(edt_post_id.text.toString()), edt_post_title.text.toString(), edt_post_body.text.toString()) //replace with values from edt, this is hardcoded
                viewModel.pushData(myPost)
                viewModel.newPost.observe(viewLifecycleOwner){
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
        return inflater.inflate(R.layout.fragment_create_post, container, false)
    }

}