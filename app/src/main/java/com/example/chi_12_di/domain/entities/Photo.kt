package com.example.chi_12_di.domain.entities

data class Photo(
    val id: Int,
    val responseId: Int,
    val url: String,
    val photographer: String,
    val photographerUrl: String,
    val photographerId: Int,
    val avgColor: String,
    val smallPhotoUrl: String
)
