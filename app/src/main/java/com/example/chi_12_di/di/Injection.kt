package com.example.chi_12_di.di

import android.content.Context
import com.example.chi_12_di.app.PhotosApplication.Companion.applicationScope
import com.example.chi_12_di.data.db.PhotosDataBase

object Injection {
    private lateinit var dataBase : PhotosDataBase

    fun initInjection(context: Context){
        dataBase = PhotosDataBase.getDataBase(context, applicationScope)
    }

    fun providePhotosDao() = dataBase.IPhotosDao
}