package com.example.vartalaap.feature_shows.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreatedProduct(
    @SerialName("category")
    val category: CreatedCategory?,
    @SerialName("creationAt")
    val creationAt: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("images")
    val images: List<String?>?,
    @SerialName("price")
    val price: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("updatedAt")
    val updatedAt: String?
)