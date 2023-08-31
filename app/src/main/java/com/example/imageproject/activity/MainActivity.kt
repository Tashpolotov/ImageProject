package com.example.imageproject.activity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.example.imageproject.R
import com.example.imageproject.databinding.ActivityMainBinding
import com.example.imageproject.fragment.BookmarkFragment
import com.example.imageproject.fragment.HomeFragment
import com.example.imageproject.onboarding.Pref
import com.example.imageproject.onboarding.ViewPagerFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var onBoardingCompletedKey: String
    private var isNavShown = true
    private var navAnimation: ObjectAnimator? = null

    @Inject
    lateinit var pref: Pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingCompletedKey = "onBoardingCompleted"
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setupBottomNavigation()
        if (savedInstanceState == null) {
            if (!pref.isBoardShow()) {
                supportFragmentManager.beginTransaction().add(R.id.fr_contaner, ViewPagerFragment())
                    .commit()
                binding.bottomNav.visibility = View.GONE
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fr_contaner, HomeFragment()).commit()
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }

    fun hideBottomNavigation() {
        if (isNavShown) {
            navAnimation?.cancel()
            navAnimation = ObjectAnimator.ofFloat(binding.bottomNav, "translationY", 0f, binding.bottomNav.height.toFloat())
            navAnimation?.duration = 800
            navAnimation?.start()
            isNavShown = false
        }
    }

    fun showBottomNavigation() {
        if (!isNavShown) {
            navAnimation?.cancel()
            navAnimation = ObjectAnimator.ofFloat(binding.bottomNav, "translationY", binding.bottomNav.height.toFloat(), 0f)
            navAnimation?.duration = 400
            navAnimation?.start()
            isNavShown = true
        }
    }
        private fun setupBottomNavigation() {
            val bottomMenu = binding.bottomNav

            val iconColorSelector =
                ContextCompat.getColorStateList(this, R.color.bottom_icon_colors)
            bottomMenu.itemIconTintList = iconColorSelector

            bottomMenu.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fr_contaner, HomeFragment())
                            .addToBackStack(null)
                            .commit()
                        true
                    }
                    R.id.bookmark -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fr_contaner, BookmarkFragment())
                            .addToBackStack(null)
                            .commit()
                        true
                    }

                    else -> false
                }
            }
        }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putBoolean(onBoardingCompletedKey, pref.isBoardShow())
        }

        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
            super.onRestoreInstanceState(savedInstanceState)
            pref.setBoardShow(
                savedInstanceState.getBoolean(
                    onBoardingCompletedKey,
                    false
                )
            )
        }

        override fun onBackPressed() {
            finish()
        }
    }