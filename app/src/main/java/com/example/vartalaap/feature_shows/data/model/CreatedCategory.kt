package com.example.vartalaap.feature_shows.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreatedCategory(
    @SerialName("creationAt")
    val creationAt: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("image")
    val image: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("updatedAt")
    val updatedAt: String?
)