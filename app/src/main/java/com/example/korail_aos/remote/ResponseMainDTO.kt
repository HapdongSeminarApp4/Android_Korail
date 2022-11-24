package com.example.korail_aos.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class ResponseMainDTO(
    @SerialName("departures")
    val email: String,
    @SerialName("arrivals")
    val password: String,
    @SerialName("date")
    val date: String
)
