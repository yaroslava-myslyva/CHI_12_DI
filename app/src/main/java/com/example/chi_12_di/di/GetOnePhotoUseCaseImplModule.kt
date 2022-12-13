package com.example.chi_12_di.di

import com.example.chi_12_di.domain.usecase.api.IGetOnePhotoUseCase
import com.example.chi_12_di.data.usecase.impl.GetOnePhotoUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface GetOnePhotoUseCaseImplModule {

    @Binds
    fun  provideGetOnePhotoUseCase (getOnePhotoUseCaseImpl :GetOnePhotoUseCaseImpl ) :IGetOnePhotoUseCase
}
