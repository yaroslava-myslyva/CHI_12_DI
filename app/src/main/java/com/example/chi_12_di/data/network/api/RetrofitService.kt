package com.example.chi_12_di.data.network.api

import com.example.chi_12_di.data.network.model.response.WholeResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    /**
     * Method for getting a new random photo
     */
    @GET("search")
    fun getResponseItem(
        @Query("query") query: String?,
        @Query("per_page") itemNum: Int
    ): Call<WholeResponseModel>
}
