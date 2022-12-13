package com.example.chi_12_di.domain.usecase.api

import com.example.chi_12_di.domain.entities.Photo
import kotlinx.coroutines.flow.Flow

interface IGetOnePhotoUseCase {
    /**
     * Method for adding new photo in the list.
     */
    suspend fun execute(): Flow<List<Photo>>
}