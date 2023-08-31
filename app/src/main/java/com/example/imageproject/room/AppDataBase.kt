package com.example.imageproject.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SavedImage::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun savedImageDao(): SavedImageDao
}