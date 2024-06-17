package com.example.vartalaap.feature_shows.presentation

import com.example.vartalaap.feature_shows.data.model.Product
import com.example.vartalaap.feature_shows.data.utils.ResponseState

data class ProductState(
    val singleProduct: ResponseState<Product> = ResponseState(),
    val allProducts: ResponseState<List<Product>> = ResponseState()
)