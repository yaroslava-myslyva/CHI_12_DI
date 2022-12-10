package com.example.chi_12_di.di

import com.example.chi_12_di.data.repository.PhotosRepositoryImplModule
import com.example.chi_12_di.domain.usecase.impl.DeleteAllPhotosUseCaseImplModule
import com.example.chi_12_di.domain.usecase.impl.GetOnePhotoUseCaseImplModule
import com.example.chi_12_di.presentation.PhotosFragment
import com.example.chi_12_di.presentation.ViewModelFactory
import dagger.Component

@Component(
    modules = [DeleteAllPhotosUseCaseImplModule::class,
        GetOnePhotoUseCaseImplModule::class,
        PhotosRepositoryImplModule::class,
        RetrofitServiceImplModule::class]
)
interface AppComponent {
    fun viewModelsFactory(): ViewModelFactory
    fun inject(photosFragment: PhotosFragment)
}