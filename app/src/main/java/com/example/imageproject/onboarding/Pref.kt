package com.example.imageproject.onboarding

import android.content.Context
import android.content.SharedPreferences
import android.text.BoringLayout
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Pref @Inject constructor(@ApplicationContext context: Context) {


        private val sharedPref : SharedPreferences = context.getSharedPreferences(
            "pref",
            Context.MODE_PRIVATE
        )

        fun isBoardShow():Boolean{
            return sharedPref.getBoolean("boardingShow", false)
        }

        fun setBoardShow(isShow:Boolean) {
            return sharedPref.edit().putBoolean("boardingShow", isShow).apply()
        }
}