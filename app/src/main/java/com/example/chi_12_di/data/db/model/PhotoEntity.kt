package com.example.chi_12_di.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

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
)
