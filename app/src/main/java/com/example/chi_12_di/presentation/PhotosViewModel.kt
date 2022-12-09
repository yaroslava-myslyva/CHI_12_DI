package com.example.chi_12_di.presentation

import androidx.lifecycle.ViewModel
import com.example.chi_12_di.data.db.model.PhotoEntity
import com.example.chi_12_di.domain.usecase.api.GetOnePhotoUseCase
import kotlinx.coroutines.flow.Flow

class PhotosViewModel(private val getOnePhotoUseCase: GetOnePhotoUseCase) : ViewModel() {
    fun getNewPhoto(): Flow<List<PhotoEntity>> = getOnePhotoUseCase.execute()
}
