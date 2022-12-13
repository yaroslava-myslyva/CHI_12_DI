package com.example.chi_12_di.domain.usecase.api

import com.example.chi_12_di.data.db.model.PhotoEntity
import com.example.chi_12_di.domain.entities.Photo
import kotlinx.coroutines.flow.Flow

interface IGetOnePhotoUseCase {
    /**
     * Method for adding new photo in the list.
     */
    suspend fun execute(): Flow<List<Photo>>
}