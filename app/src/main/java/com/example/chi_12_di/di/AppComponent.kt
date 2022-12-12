package com.example.chi_12_di.di

import com.example.chi_12_di.presentation.PhotosFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DeleteAllPhotosUseCaseImplModule::class,
        GetOnePhotoUseCaseImplModule::class,
        PhotosRepositoryImplModule::class,
        RetrofitServiceImplModule::class,
        ViewModelModule::class]
)
interface AppComponent {
    fun inject(photosFragment: PhotosFragment)
}