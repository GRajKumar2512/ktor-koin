package com.example.vartalaap.feature_shows.data.utils

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import java.io.IOException


sealed class Response<out T> {
    data class Success<out T>(val body: T) : Response<T>()

    data class Error<out T>(val message: String,val errorBody: T) : Response<T>()

    data class Exception(val e: Throwable) : Response<Nothing>()
}

/*
fun message() = when(val event = this.exception){
            is IOException -> "No internet"
            is ServerResponseException -> "Server error:${event.response.status.value}"
            is ClientRequestException ->
                when (event.response.status.value) {
                    400 -> "bad request: 400"
                    401 -> "Unauthorized: 401"
                    403 -> "Forbidden: 403"
                    404 -> "NotFound: 404"
                    else -> "Client Side Error: ${event.response.status.description}"
                }
            is RedirectResponseException -> "Redirection error. Please try again."
            else -> "Unknown Error: ${event.message}"
        }
 */