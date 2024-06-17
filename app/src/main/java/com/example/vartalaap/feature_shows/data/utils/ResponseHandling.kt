package com.example.vartalaap.feature_shows.data.utils

import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.utils.io.errors.IOException
import java.net.ConnectException
import java.net.UnknownHostException

suspend inline fun <reified T> handleHttpResponse(execute: () -> HttpResponse): Response<T> {
    return try {
        val response = execute()
        if(response.status.isSuccess()){
            Response.Success(response.body<T>())
        } else {
            Response.Error(message = "${response.status.value} -> ${response.status.description}", errorBody = response.body<T>())
        }
    } catch (e: Exception) {
        Response.Exception(e)
    }
}

/*
catch (e: IOException) {
        Response.Error("Network error. Please check your internet connection and try again.")
    } catch (e: ClientRequestException) {
        return when (e.response.status) {
            HttpStatusCode.BadRequest -> Response.Error("bad request: 400")
            HttpStatusCode.Unauthorized -> Response.Error("Unauthorized: 401")
            HttpStatusCode.Forbidden -> Response.Error("Forbidden: 403")
            HttpStatusCode.NotFound -> Response.Error("NotFound: 404")
            else -> Response.Error("Client Side Error: ${e.response.status.description}")
        }
    } catch (e: ServerResponseException) {
        Response.Error("Server error. Please try again later.")
    } catch (e: RedirectResponseException) {
        Response.Error("Redirection error. Please try again.")
    } catch (e: HttpRequestTimeoutException) {
        Response.Error("Request timed out. Please try again.")
    } catch (e: UnknownHostException) {
        Response.Error("Unable to reach the server. Please check your internet connection.")
    } catch (e: ConnectException) {
        Response.Error("Failed to connect to the server. Please try again later.")
    }
 */