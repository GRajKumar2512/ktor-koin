package com.example.vartalaap.feature_shows.domain.repository

import com.example.vartalaap.feature_shows.data.model.CreateProduct
import com.example.vartalaap.feature_shows.data.model.CreatedProduct
import com.example.vartalaap.feature_shows.data.model.Product
import com.example.vartalaap.feature_shows.data.utils.Response
import com.example.vartalaap.feature_shows.data.utils.ResponseState
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts(limit: Int?, offset: Int?): Flow<ResponseState<List<Product>>>
    fun getSingleProduct(id: Int): Flow<ResponseState<Product>>
    suspend fun createProduct(body: CreateProduct): Response<CreatedProduct>
    suspend fun updateProduct(id: Int): Response<CreatedProduct>
    suspend fun deleteProduct(id: Int): Response<Boolean>
}