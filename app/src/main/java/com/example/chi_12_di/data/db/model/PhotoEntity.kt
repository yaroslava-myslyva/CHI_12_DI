package com.example.chi_12_di.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chi_12_di.domain.entities.Photo

@Entity(tableName = "photoEntity")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val response_id: Int,
    val url: String,
    val photographer: String,
    val photographer_url: String,
    val photographer_id: Int,
    val avg_color: String,
    val small_photo_url: String
) {
    fun mapToPhoto(): Photo = Photo(
        id = id ?: 0,
        responseId = response_id,
        url = url,
        photographer = photographer,
        photographerUrl = photographer_url,
        photographerId = photographer_id,
        avgColor = avg_color,
        smallPhotoUrl = small_photo_url
    )
}
