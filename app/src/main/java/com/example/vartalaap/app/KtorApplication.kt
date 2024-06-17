package com.example.vartalaap.app

import android.app.Application
import com.example.vartalaap.feature_shows.data.di.networkModule
import com.example.vartalaap.feature_shows.domain.di.repoModule
import org.koin.core.context.startKoin

class KtorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(networkModule, repoModule)
        }
    }
}