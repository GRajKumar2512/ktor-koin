package com.example.vartalaap.feature_shows.data.utils

data class AppError<E>(val message: String? = null, val errorBody: E? = null)