package com.example.chi_12_di.app

import android.app.Application
import android.util.Log
import com.example.chi_12_di.di.Injection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class PhotosApplication : Application() {
    companion object {
        val applicationScope = CoroutineScope(SupervisorJob())
    }

    override fun onCreate() {
        super.onCreate()
        Injection.initInjection(this)
    }
}