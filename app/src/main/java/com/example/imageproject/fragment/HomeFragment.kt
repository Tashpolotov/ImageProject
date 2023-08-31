    package com.example.imageproject.fragment

    import android.graphics.Color.blue
    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.core.content.ContextCompat
    import com.example.imageproject.R
    import com.example.imageproject.databinding.FragmentHomeBinding
    import com.google.android.material.button.MaterialButton


    class HomeFragment : Fragment() {

        private lateinit var binding: FragmentHomeBinding
        private var selectedButton: MaterialButton? = null


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentHomeBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            initBtn()
            setSelectedButton(binding.btnForYou)
            setImagesForYou()
        }

        private fun initBtn() {
            binding.btnForYou.setOnClickListener {
                setImagesForYou()
                setSelectedButton(binding.btnForYou)
            }
            binding.btnLearning.setOnClickListener {
                setImagesLearning()
                setSelectedButton(binding.btnLearning)
            }
            binding.btnIllustration.setOnClickListener {
                setImagesIllustration()
                setSelectedButton(binding.btnIllustration)
            }
        }

        private fun setImagesForYou() = with(binding) {

            binding.imageView1.visibility = View.VISIBLE
            binding.imageView2.visibility = View.VISIBLE
            binding.imageView3.visibility = View.VISIBLE
            binding.imageView4.visibility = View.VISIBLE
            binding.imageView6.visibility = View.VISIBLE
            binding.imageView5.visibility = View.VISIBLE

            binding.imageView7.visibility = View.GONE
            binding.imageView8.visibility = View.GONE
            binding.imageView9.visibility = View.GONE
            binding.imageView10.visibility = View.GONE
            binding.imageView11.visibility = View.GONE
            binding.imageView12.visibility = View.GONE


            binding.imageView1.setImageResource(com.example.data.R.drawable.img_1)
            binding.imageView2.setImageResource(com.example.data.R.drawable.img_2)
            binding.imageView3.setImageResource(com.example.data.R.drawable.img_3)
            binding.imageView4.setImageResource(com.example.data.R.drawable.img_4)
            binding.imageView5.setImageResource(com.example.data.R.drawable.img_5)
            binding.imageView6.setImageResource(com.example.data.R.drawable.img_6)


            imageView5.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_5)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView5 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

            imageView6.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_6)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView6 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

            imageView4.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_4)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView4 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

            imageView3.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_3)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView3 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

            imageView1.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_1)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView1 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

            imageView2.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_2)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView2 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

        }

        private fun setImagesLearning() = with(binding){
            imageView7.visibility = View.VISIBLE
            imageView8.visibility = View.VISIBLE
            imageView9.visibility = View.VISIBLE
            imageView10.visibility = View.VISIBLE


            binding.imageView1.visibility = View.GONE
            binding.imageView2.visibility = View.GONE
            binding.imageView3.visibility = View.GONE
            binding.imageView4.visibility = View.GONE
            binding.imageView5.visibility = View.GONE
            binding.imageView6.visibility = View.GONE
            binding.imageView11.visibility = View.GONE
            binding.imageView12.visibility = View.GONE

            imageView7.setImageResource(com.example.data.R.drawable.img_1)
            imageView8.setImageResource(com.example.data.R.drawable.img_2)

            imageView9.setImageResource(com.example.data.R.drawable.img_4)
            imageView10.setImageResource(com.example.data.R.drawable.img_6)

            imageView10.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_6)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView10 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

            imageView9.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_4)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView9 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

            imageView7.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_1)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView7 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }


            imageView8.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_2)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView8 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }


        }

        private fun setImagesIllustration()= with(binding) {

            binding.imageView11.visibility = View.VISIBLE
            binding.imageView12.visibility = View.VISIBLE
            binding.imageView1.visibility = View.GONE
            binding.imageView2.visibility = View.GONE
            binding.imageView3.visibility = View.GONE
            binding.imageView4.visibility = View.GONE
            binding.imageView5.visibility = View.GONE
            binding.imageView6.visibility = View.GONE
            binding.imageView7.visibility = View.GONE
            binding.imageView8.visibility = View.GONE
            binding.imageView9.visibility = View.GONE
            binding.imageView10.visibility = View.GONE

            binding.imageView11.setImageResource(com.example.data.R.drawable.img_3)
            binding.imageView12.setImageResource(com.example.data.R.drawable.img_2)


            imageView11.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_3)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView11 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }


            imageView12.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("img", com.example.data.R.drawable.img_2)
                val imageDetailFragment = ImageDetailFragment()
                imageDetailFragment.arguments = bundle
                imageDetailFragment.targetImageViewId = R.id.imageView12 // Сохраняем ID ImageView
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fr_contaner, imageDetailFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }

        }

        private fun setSelectedButton(button: MaterialButton) {
            selectedButton?.let { previousButton ->
                previousButton.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.grey)
            }

            button.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.explorer_color_text)
            selectedButton = button
        }
    }