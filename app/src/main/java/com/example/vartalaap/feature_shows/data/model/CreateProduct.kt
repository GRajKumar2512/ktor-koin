package com.example.vartalaap.feature_shows.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateProduct(
    @SerialName("categoryId")
    val categoryId: Int = 0,
    @SerialName("description")
    val description: String = "",
    @SerialName("images")
    val images: List<String> = listOf(),
    @SerialName("price")
    val price: Int = 0,
    @SerialName("title")
    val title: String = ""
)