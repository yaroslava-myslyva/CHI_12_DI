package com.example.chi_12_di.data.repository

import android.util.Log
import com.example.chi_12_di.MainActivity.Companion.TAG
import com.example.chi_12_di.data.db.dao.IPhotosDao
import com.example.chi_12_di.data.db.model.PhotoEntity
import com.example.chi_12_di.data.network.api.IRetrofitService
import com.example.chi_12_di.data.network.model.response.WholeResponseModel
import com.example.chi_12_di.di.Injection
import com.example.chi_12_di.domain.repository.IPhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val IRetrofitService: IRetrofitService
    ) : IPhotosRepository {

    private val dao: IPhotosDao = Injection.providePhotosDao()

    companion object {
        private var instance: PhotosRepositoryImpl? = null
        fun getInstance(
            IRetrofitService: IRetrofitService
        ): PhotosRepositoryImpl {
            if (instance == null) {
                instance = PhotosRepositoryImpl(IRetrofitService)
            }
            return instance as PhotosRepositoryImpl
        }
    }

    override suspend fun addPhoto() {
        kotlin.runCatching {
            val photoResponse =
                IRetrofitService.getResponseItem(
                    listOf(('0'..'9'), ('a'..'z'), ('A'..'Z')).flatten().random().toString(), 1
                ).execute()
            val wholeResponseModelBody = photoResponse.body() as WholeResponseModel

            wholeResponseModelBody.photos?.forEach { photoResponseModel ->
                photoResponseModel.mapToPhotoEntity().let { photoEntity ->
                    dao.addPhoto(photoEntity)
                }

            }
        }.onFailure {
            Log.d(TAG, "error - ${it.message}")
        }
    }

    override fun fetchAllPhotos(): Flow<List<PhotoEntity>> = dao.fetchPhotos()

    override fun deleteAllPhotos() = dao.deleteAllPhotos()
}