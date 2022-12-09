package com.example.chi_12_di.data.network.model.response

import com.google.gson.annotations.SerializedName

data class WholeResponseModel(
    val page: Long?,

    @SerializedName("per_page")
    val perPage: Long?,

    val photos: List<PhotoResponseModel>?,

    @SerializedName("total_results")
    val totalResults: Long?,

    @SerializedName("next_page")
    val nextPage: String?
)
