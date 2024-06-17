package com.example.vartalaap.feature_shows.data.di

import android.util.Log
import com.example.vartalaap.feature_shows.data.remote.ApiService
import com.example.vartalaap.feature_shows.data.remote.ApiServiceImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(OkHttp) {// okhttp support http/2 whereas android doesn't
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = 1)
                exponentialDelay()
            }

            install(Logging) {
                level = LogLevel.ALL
                logger = Logger.SIMPLE
            }

            install(ResponseObserver) {
                onResponse {
                    Log.v("http", "status: ${it.status.value}")
                }
            }

            install(DefaultRequest) {
                url("https://api.escuelajs.co/")
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }

    single<ApiService> { ApiServiceImpl(get()) }
}