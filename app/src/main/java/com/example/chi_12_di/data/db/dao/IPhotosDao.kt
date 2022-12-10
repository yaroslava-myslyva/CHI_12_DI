package com.example.chi_12_di.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chi_12_di.data.db.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IPhotosDao {

    /**
     * Method for adding one photo
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPhoto(animal : PhotoEntity)

    /**
     * Method for getting all photos
     */
    @Query("SELECT * FROM photoEntity")
    fun fetchPhotos(): Flow<List<PhotoEntity>>

    /**
     * Method for deletion all photos
     */
    @Query("DELETE FROM photoEntity")
    fun deleteAllPhotos()
}