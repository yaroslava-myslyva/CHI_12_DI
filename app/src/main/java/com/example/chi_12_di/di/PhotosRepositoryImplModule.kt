package com.example.chi_12_di.di

import com.example.chi_12_di.data.repository.PhotosRepositoryImpl
import com.example.chi_12_di.domain.repository.IPhotosRepository
import dagger.Binds
import dagger.Module

@Module
interface PhotosRepositoryImplModule {

    @Binds
    fun providePhotosRepository(photosRepository: PhotosRepositoryImpl): IPhotosRepository
}
