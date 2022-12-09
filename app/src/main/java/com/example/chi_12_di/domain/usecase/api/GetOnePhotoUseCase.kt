package com.example.chi_12_di.domain.usecase.api

import com.example.chi_12_di.data.db.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface GetOnePhotoUseCase {
    /**
     * Method for adding new photo in the list.
     */
    fun execute(): Flow<List<PhotoEntity>>
}