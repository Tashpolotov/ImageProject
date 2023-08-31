package com.example.imageproject

import android.app.Application
import androidx.room.Room
import com.example.imageproject.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App :Application(){

    val database: AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "my-database").build()

    }
}