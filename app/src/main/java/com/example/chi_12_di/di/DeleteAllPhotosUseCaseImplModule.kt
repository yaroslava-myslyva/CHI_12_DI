package com.example.chi_12_di.di

import com.example.chi_12_di.domain.usecase.api.IDeleteAllPhotosUseCase
import com.example.chi_12_di.domain.usecase.impl.DeleteAllPhotosUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface DeleteAllPhotosUseCaseImplModule {

    @Binds
    fun provideIDeleteAllPhotosUseCase(deleteAllPhotosUseCaseImpl: DeleteAllPhotosUseCaseImpl): IDeleteAllPhotosUseCase
}
