package com.example.chi_12_di.data.repository;

import com.example.chi_12_di.domain.repository.IPhotosRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotosRepositoryImplModule {

    @Provides
    IPhotosRepository providePhotosRepository (PhotosRepositoryImpl photosRepository){
        return photosRepository;
    }
}
