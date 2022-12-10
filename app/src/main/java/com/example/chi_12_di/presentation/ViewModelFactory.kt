package com.example.chi_12_di.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chi_12_di.di.Injection
import com.example.chi_12_di.domain.usecase.api.IDeleteAllPhotosUseCase
import com.example.chi_12_di.domain.usecase.api.IGetOnePhotoUseCase
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val getOnePhotoUseCase: IGetOnePhotoUseCase,
    private val deleteAllPhotosUseCase: IDeleteAllPhotosUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == PhotosViewModel::class.java) {
            return PhotosViewModel(
                getOnePhotoUseCase, deleteAllPhotosUseCase
            ) as T

        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(): ViewModelFactory {
            if (INSTANCE == null) {
                INSTANCE = ViewModelFactory(
                    Injection.provideGetOnePhotoUseCase(),
                    Injection.provideDeleteAllPhotosUseCase()
                )
            }
            return INSTANCE!!
        }
    }
}
