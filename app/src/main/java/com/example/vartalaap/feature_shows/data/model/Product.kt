package com.example.vartalaap.feature_shows.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("id") var id: Int? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("price") var price: Int? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("category") var category: CreatedCategory? = null,
    @SerialName("images") var images: ArrayList<String> = arrayListOf(),
    @SerialName("message") var message: String? = null
)
