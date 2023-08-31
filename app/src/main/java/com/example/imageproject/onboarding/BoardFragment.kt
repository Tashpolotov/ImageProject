package com.example.imageproject.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imageproject.R
import com.example.imageproject.activity.MainActivity
import com.example.imageproject.databinding.FragmentBoardBinding
import com.example.imageproject.fragment.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment : Fragment() {

    private lateinit var binding:FragmentBoardBinding

    @Inject lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("board") as BoardingModel


        binding.tvName.text = data.title
        binding.tvDesc.text = data.des
        data.image?.let { it1 -> binding.img.setImageResource(it1) }

        binding.btnNext.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.fr_contaner, HomeFragment())
                .commit()
            pref.setBoardShow(true)
            (activity as? MainActivity)?.binding?.bottomNav?.visibility = View.VISIBLE
        }
    }
}