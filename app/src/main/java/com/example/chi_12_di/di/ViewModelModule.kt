package com.example.chi_12_di.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chi_12_di.presentation.PhotosViewModel
import com.example.chi_12_di.presentation.ViewModelFactory
import com.example.chi_12_di.presentation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Singleton
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory) :ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    fun bindAuthFeatureViewModel(photosViewModel: PhotosViewModel) :ViewModel
}