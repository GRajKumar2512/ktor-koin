package com.example.vartalaap.feature_shows.data.repository

import com.example.vartalaap.feature_shows.data.model.CreateProduct
import com.example.vartalaap.feature_shows.data.model.CreatedProduct
import com.example.vartalaap.feature_shows.data.model.Product
import com.example.vartalaap.feature_shows.data.remote.ApiService
import com.example.vartalaap.feature_shows.data.utils.Response
import com.example.vartalaap.feature_shows.data.utils.ResponseState
import com.example.vartalaap.feature_shows.data.utils.wrapResponseToState
import com.example.vartalaap.feature_shows.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppProductRepository(private val service: ApiService) : ProductRepository {
    override  fun getAllProducts(
        limit: Int?,
        offset: Int?
    ): Flow<ResponseState<List<Product>>> {
        return wrapResponseToState<List<Product>>{ service.getAllProducts(limit, offset) }
    }

    override  fun getSingleProduct(id: Int): Flow<ResponseState<Product>> {
        return wrapResponseToState<Product>{ service.getSingleProduct(id) }
    }

    override suspend fun createProduct(body: CreateProduct): Response<CreatedProduct> {
        return service.createProduct(body)
    }

    override suspend fun updateProduct(id: Int): Response<CreatedProduct> {
        return service.updateProduct(id)
    }

    override suspend fun deleteProduct(id: Int): Response<Boolean> {
        return service.deleteProduct(id)
    }
}