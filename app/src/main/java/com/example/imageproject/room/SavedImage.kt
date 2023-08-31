package com.example.imageproject.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_images")
data class SavedImage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, // Изменили тип ID на Long
    val imageResourceId: Int,
    val targetImageViewId: Int,
    val order: Int
)