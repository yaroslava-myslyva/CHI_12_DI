package com.example.chi_12_di.domain.usecase.impl;

import com.example.chi_12_di.domain.usecase.api.IDeleteAllPhotosUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class DeleteAllPhotosUseCaseImplModule {

    @Provides
    IDeleteAllPhotosUseCase provideIDeleteAllPhotosUseCase (DeleteAllPhotosUseCaseImpl deleteAllPhotosUseCaseImpl){
        return deleteAllPhotosUseCaseImpl;
    }
}
