package com.example.imageproject.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.imageproject.R
import com.example.imageproject.databinding.ActivitySplashscreenBinding

class SplashscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

        binding.imgSplashScreen.alpha = 0f
        binding.imgSplashScreen.animate().setDuration(1500).alpha(1f)

    }
}