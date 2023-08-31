package com.example.imageproject.module

import com.example.data.ImageRepositoryMock
import com.example.domain.repository.ImageRepository
import com.example.domain.usecase.ImageUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun provideRepository():ImageRepository{
        return ImageRepositoryMock()
    }

    @Provides
    @Singleton
    fun provideUseCase(repository:ImageRepository):ImageUseCase{
        return ImageUseCase(repository)
    }
}