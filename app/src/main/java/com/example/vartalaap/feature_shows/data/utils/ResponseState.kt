package com.example.vartalaap.feature_shows.data.utils

data class ResponseState<T>(
    val data: T? = null,
    val error: AppError<T>? = null,
    val loading: Boolean = false
)