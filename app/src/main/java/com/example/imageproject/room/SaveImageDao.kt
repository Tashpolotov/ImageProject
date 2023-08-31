package com.example.imageproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SavedImageDao {
    @Insert
    suspend fun insert(savedImage: SavedImage)

    @Query("SELECT * FROM saved_images ORDER BY `order` ASC")
    suspend fun getAllSavedImagesSortedByOrder(): List<SavedImage>
}