package com.example.chi_12_di.domain.repository

import com.example.chi_12_di.domain.entities.Photo
import kotlinx.coroutines.flow.Flow

interface IPhotosRepository {

    /**
     * Method for adding a new photo from the internet.
     */
    suspend fun addPhoto()

    /**
     *  Method for getting all photos from the database.
     */
    fun fetchAllPhotos(): Flow<List<Photo>>

    /**
     * Method for deletion all photos from the database.
     */
    fun deleteAllPhotos()
}