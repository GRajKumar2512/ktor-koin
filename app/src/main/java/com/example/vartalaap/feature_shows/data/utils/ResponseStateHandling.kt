package com.example.vartalaap.feature_shows.data.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

inline fun <reified T> wrapResponseToState(crossinline execute: suspend () -> Response<T>): Flow<ResponseState<T>> {
    return flow {
        emit(ResponseState(loading = true))
        when (val response = execute()) {
            is Response.Success -> emit(ResponseState(data = response.body, loading = false))

            is Response.Error -> emit(
                ResponseState(
                    error = AppError(
                        message = response.message,
                        errorBody = response.errorBody
                    ), loading = false
                )
            )

            is Response.Exception -> emit(
                ResponseState(
                    error = AppError(message = response.e.message),
                    loading = false
                )
            )
        }
    }
}

/*
val _responseState = MutableStateFlow(ResponseState<T>())
    val responseState = _responseState.asStateFlow()
    _responseState.update { it.copy(loading = true) }
    Log.v("wrapResponseToState", "loading true")
    coroutineScope {
        when (val response = execute()) {
            is Response.Success -> _responseState.update {
                Log.v("wrapResponseToState", "Success")
                it.copy(data = response.body, loading = false)
            }

            is Response.Error -> _responseState.update {
                Log.v("wrapResponseToState", "Error")
                it.copy(error = AppError(message = response.message, errorBody = response.errorBody), loading = false)
            }

            is Response.Exception -> _responseState.update {
                Log.v("wrapResponseToState", "Exception")
                it.copy(error = AppError(message = response.e.message), loading = false)
            }
        }
    }
    Log.v("wrapResponseToState", "return")
    return responseState
 */