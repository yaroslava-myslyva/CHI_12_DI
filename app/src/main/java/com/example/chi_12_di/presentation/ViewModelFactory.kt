package com.example.chi_12_di.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<PhotosViewModel>

) : ViewModelProvider.Factory {
    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        PhotosViewModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == PhotosViewModel::class.java) {

            return providers[modelClass]!!.get() as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}
