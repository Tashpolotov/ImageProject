package com.example.imageproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.imageproject.R

class FullscreenImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_fullscreen_image, container, false)
        val fullscreenImageView = rootView.findViewById<ImageView>(R.id.fullscreen_image_view)

        fullscreenImageView.setOnClickListener {
            val fragment = requireActivity().supportFragmentManager
            fragment.popBackStack()
        }

        val imageResource = arguments?.getInt("img") ?: 0
        if (imageResource != 0) {
            fullscreenImageView.setImageResource(imageResource)
        }


        return rootView
    }
}