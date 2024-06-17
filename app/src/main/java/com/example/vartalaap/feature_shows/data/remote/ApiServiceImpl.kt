package com.example.vartalaap.feature_shows.data.remote

import com.example.vartalaap.feature_shows.data.model.CreateProduct
import com.example.vartalaap.feature_shows.data.model.CreatedProduct
import com.example.vartalaap.feature_shows.data.model.Product
import com.example.vartalaap.feature_shows.data.utils.Response
import com.example.vartalaap.feature_shows.data.utils.handleHttpResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

class ApiServiceImpl(private val client: HttpClient) : ApiService {
    override suspend fun getAllProducts(limit: Int?, offset: Int?): Response<List<Product>> {
        return handleHttpResponse<List<Product>> {
            client.get(ApiConstants.PRODUCTS) {
                parameter("limit", limit)
                parameter("offset", offset)
            }
        }
    }

    override suspend fun getSingleProduct(id: Int): Response<Product> {
        return handleHttpResponse<Product> { client.get(ApiConstants.PRODUCTS + "/$id") }
    }

    override suspend fun createProduct(body: CreateProduct): Response<CreatedProduct> {
        return handleHttpResponse<CreatedProduct> {
            client.post(ApiConstants.PRODUCTS + "/") {
                setBody(body)
            }
        }
    }

    override suspend fun updateProduct(id: Int): Response<CreatedProduct> {
        return handleHttpResponse<CreatedProduct> {
            client.put(ApiConstants.PRODUCTS + "/$id").body()
        }
    }

    override suspend fun deleteProduct(id: Int): Response<Boolean> {
        return handleHttpResponse<Boolean> {
            client.delete(ApiConstants.PRODUCTS + "/$id").body()
        }
    }
}