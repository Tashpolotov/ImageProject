package com.example.imageproject.fragment

import android.content.Context
import android.util.Log

class PreferenceManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("image_preferences", Context.MODE_PRIVATE)

    fun saveImage(imageResourceId: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("saved_image", imageResourceId)
        editor.apply()

        Log.d("PreferenceManager", "Image saved with resource ID: $imageResourceId")
    }

    fun getSavedImage(): Int {
        val savedImageResourceId = sharedPreferences.getInt("saved_image", 0)

        Log.d("PreferenceManager", "Image loaded with resource ID: $savedImageResourceId")

        return savedImageResourceId
    }
}