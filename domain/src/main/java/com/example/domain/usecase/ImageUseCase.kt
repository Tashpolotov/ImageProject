package com.example.domain.usecase

import com.example.domain.repository.ImageRepository

class ImageUseCase(val repository: ImageRepository) {

    operator fun  invoke(id:String){
        repository.getHomeButton(id)
        repository.getHomeImage(id)
    }
}