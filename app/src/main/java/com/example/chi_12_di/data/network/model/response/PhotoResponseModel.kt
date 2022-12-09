package com.example.chi_12_di.data.network.model.response

import com.example.chi_12_di.data.db.model.PhotoEntity
import com.google.gson.annotations.SerializedName

data class PhotoResponseModel(
    val id: Int?,
    val width: Int?,
    val height: Int?,
    val url: String?,
    val photographer: String?,

    @SerializedName("photographer_url")
    val photographerURL: String?,

    @SerializedName("photographer_id")
    val photographerID: Int?,

    @SerializedName("avg_color")
    val avgColor: String?,

    val src: SrcResponseModel?,
    val liked: Boolean?,
    val alt: String?
) {
    fun mapToPhotoEntity(): PhotoEntity = PhotoEntity(
        response_id = id ?: 0,
        url = url ?: "",
        photographer = photographer ?: "",
        photographer_url = photographerURL ?: "",
        photographer_id = photographerID ?: 0,
        avg_color = avgColor ?: "",
        small_photo_url = src?.small ?: ""
    )
}
