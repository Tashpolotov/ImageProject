package com.example.imageproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.model.HomeImageModel
import com.example.domain.model.HomeModel
import com.example.domain.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val repository: ImageRepository):ViewModel() {

    private val _imageButton = MutableStateFlow<List<HomeModel>>(emptyList())
    val imageButton:StateFlow<List<HomeModel>> = _imageButton

    private val _image = MutableStateFlow<List<HomeImageModel>>(emptyList())
    val image :StateFlow<List<HomeImageModel>> = _image


    fun loadHomeImage(id:String) {
        val image = repository.getHomeImage(id)
        _image.value = image
    }

    fun loadHomeImageButton(id:String){
        val imageButton = repository.getHomeButton(id)
        _imageButton.value = imageButton

    }

}