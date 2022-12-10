package com.example.chi_12_di.presentation

import androidx.lifecycle.ViewModel
import com.example.chi_12_di.data.db.model.PhotoEntity
import com.example.chi_12_di.domain.usecase.api.IDeleteAllPhotosUseCase
import com.example.chi_12_di.domain.usecase.api.IGetOnePhotoUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotosViewModel @Inject constructor(
    private val getOnePhotoUseCase: IGetOnePhotoUseCase,
    private val deleteAllPhotosUseCase: IDeleteAllPhotosUseCase
) : ViewModel() {

    fun getNewPhoto(): Flow<List<PhotoEntity>> = getOnePhotoUseCase.execute()

    fun deleteAllPhotos() = deleteAllPhotosUseCase.execute()
}
