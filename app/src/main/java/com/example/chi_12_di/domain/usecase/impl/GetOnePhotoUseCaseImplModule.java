package com.example.chi_12_di.domain.usecase.impl;

import com.example.chi_12_di.domain.usecase.api.IGetOnePhotoUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class GetOnePhotoUseCaseImplModule {

    @Provides
    IGetOnePhotoUseCase provideGetOnePhotoUseCase (GetOnePhotoUseCaseImpl getOnePhotoUseCaseImpl){
        return getOnePhotoUseCaseImpl;
    }
}
