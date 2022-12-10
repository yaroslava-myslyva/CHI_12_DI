package com.example.chi_12_di.domain.usecase.api

import com.example.chi_12_di.data.db.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface IDeleteAllPhotosUseCase {
    /**
     * Method for deletion all photos.
     */
    fun execute()
}