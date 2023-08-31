package com.example.data

import com.example.domain.model.HomeImageModel
import com.example.domain.model.HomeModel
import com.example.domain.repository.ImageRepository

class ImageRepositoryMock:ImageRepository {


    override fun getHomeButton(id: String): List<HomeModel> {
        return listOf(
            HomeModel(
            "1", "For you"
        ),
        HomeModel("2", "Learning"),
            HomeModel("3", "Illustration"),
            HomeModel("4", "Aza")

        )
    }

    override fun getHomeImage(id: String): List<HomeImageModel>  {
       return listOf(

       HomeImageModel("2", R.drawable.img_1),
           HomeImageModel("2", R.drawable.img_2),
           HomeImageModel("2", R.drawable.img_3),
           HomeImageModel("2", R.drawable.img_4),
           HomeImageModel("2", R.drawable.img_5),
           HomeImageModel("2", R.drawable.img_6),

           )

    }

}