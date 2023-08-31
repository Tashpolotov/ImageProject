package com.example.imageproject.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.widget.NestedScrollView
import com.example.imageproject.App
import com.example.imageproject.R
import com.example.imageproject.databinding.FragmentBookmarkBinding
import com.example.imageproject.room.SavedImageDao
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding
    private lateinit var savedImageDao: SavedImageDao
    private val imageViewMap = mutableMapOf<Int, ShapeableImageView>()

    private val imageViewIds = arrayOf(
        R.id.imageView1, R.id.imageView2, R.id.imageView3,
        R.id.imageView4, R.id.imageView5, R.id.imageView6,
        R.id.imageView7, R.id.imageView8, R.id.imageView9,
        R.id.imageView10, R.id.imageView11, R.id.imageView12
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        savedImageDao = (requireActivity().application as App).database.savedImageDao()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (imageViewId in imageViewIds) {
            val imageView = view.findViewById<ShapeableImageView>(imageViewId)
            imageViewMap[imageViewId] = imageView
        }

        binding.imgBack.setOnClickListener {
            val fragment = requireActivity().supportFragmentManager
            fragment.popBackStack()
        }

        val nestedScrollView = view.findViewById<NestedScrollView>(R.id.nescrolled)
        val buttonLayout = view.findViewById<LinearLayout>(R.id.btn_lenar_save)

        nestedScrollView.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            if (scrollY > 0) {
                buttonLayout.visibility = View.INVISIBLE
            } else {
                buttonLayout.visibility = View.VISIBLE
            }
        }

        GlobalScope.launch(Dispatchers.IO) {
            val savedImages = savedImageDao.getAllSavedImagesSortedByOrder()
            withContext(Dispatchers.Main) {
                for (savedImage in savedImages) {
                    val targetImageView = imageViewMap[savedImage.targetImageViewId]
                    targetImageView?.apply {
                        if (savedImage.imageResourceId != 0) {
                            visibility = View.VISIBLE
                            setImageResource(savedImage.imageResourceId)
                        } else {
                            visibility = View.GONE
                        }
                    }
                }
            }
        }
    }
}