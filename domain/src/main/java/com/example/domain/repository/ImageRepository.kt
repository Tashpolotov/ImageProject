package com.example.domain.repository

import com.example.domain.model.HomeImageModel
import com.example.domain.model.HomeModel

interface ImageRepository {

    fun getHomeButton(id:String):List<HomeModel>

    fun getHomeImage(id:String):List<HomeImageModel>

}