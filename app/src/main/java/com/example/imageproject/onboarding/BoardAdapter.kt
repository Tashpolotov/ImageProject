package com.example.imageproject.onboarding

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imageproject.R
import dagger.hilt.android.qualifiers.ApplicationContext

class BoardAdapter(@ApplicationContext fragment: FragmentActivity):FragmentStateAdapter(fragment) {

    val listBoarding = listOf(
        BoardingModel(
            "Welcome aboard!",
            R.drawable.board1,
            "Welcome to the world of photography. Here, each snapshot is a window to unique moments and experiences."
        ),
        BoardingModel(
            "Immerse Yourself",
            R.drawable.board2,
            "Unleash your creative side with our app. Here, you can not only capture moments, but also share them."
        )
    )

    override fun getItemCount(): Int {
        return listBoarding.size
    }

    override fun createFragment(position: Int): Fragment {
        val bundle = bundleOf("board" to listBoarding[position])
        val fragment  = BoardFragment()
        fragment.arguments = bundle
        return fragment
    }


}