package com.example.chi_12_di.data.usecase.impl

import com.example.chi_12_di.domain.entities.Photo
import com.example.chi_12_di.domain.repository.IPhotosRepository
import com.example.chi_12_di.domain.usecase.api.IGetOnePhotoUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnePhotoUseCaseImpl @Inject constructor(private val repository: IPhotosRepository) : IGetOnePhotoUseCase {

    override suspend fun execute(): Flow<List<Photo>> {
            repository.addPhoto()
        return repository.fetchAllPhotos()
    }
}