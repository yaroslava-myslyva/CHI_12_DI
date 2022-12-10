package com.example.chi_12_di.domain.usecase.impl

import com.example.chi_12_di.data.db.model.PhotoEntity
import com.example.chi_12_di.domain.repository.IPhotosRepository
import com.example.chi_12_di.domain.usecase.api.IGetOnePhotoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GetOnePhotoUseCaseImpl(private val repository: IPhotosRepository) : IGetOnePhotoUseCase {
    override fun execute(): Flow<List<PhotoEntity>> {

        MainScope().launch(Dispatchers.IO) {
            repository.addPhoto()

        }
        return repository.fetchAllPhotos()
    }
}