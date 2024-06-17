package com.example.vartalaap.feature_shows.data.remote

import com.example.vartalaap.feature_shows.data.model.CreateProduct
import com.example.vartalaap.feature_shows.data.model.CreatedProduct
import com.example.vartalaap.feature_shows.data.model.Product
import com.example.vartalaap.feature_shows.data.utils.Response


interface ApiService {
    suspend fun getAllProducts(limit: Int?, offset: Int?): Response<List<Product>>
    suspend fun getSingleProduct(id: Int): Response<Product>
    suspend fun createProduct(body: CreateProduct): Response<CreatedProduct>
    suspend fun updateProduct(id: Int): Response<CreatedProduct>
    suspend fun deleteProduct(id: Int): Response<Boolean>
}