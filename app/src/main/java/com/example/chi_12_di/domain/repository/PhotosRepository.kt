package com.example.chi_12_di.domain.repository

import com.example.chi_12_di.data.db.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    /**
     * Method for adding a new photo from the internet.
     */
    suspend fun addPhoto()

    /**
     *  Method for getting all photos from the database.
     */
    fun fetchAllPhotos(): Flow<List<PhotoEntity>>
}