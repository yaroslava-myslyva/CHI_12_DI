package com.example.chi_12_di.di

import com.example.chi_12_di.BuildConfig
import com.example.chi_12_di.data.network.api.IRetrofitService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitServiceImplModule {
    private val BASE_URL = BuildConfig.BASE_URL
    private val API_KEY = BuildConfig.API_KEY

    @Provides
    fun provideRetrofitService(): IRetrofitService {
        val okHttpClient = OkHttpClient().newBuilder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", API_KEY)
                .build()
            chain.proceed(newRequest)
        }
        return Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(IRetrofitService::class.java)
    }
}