package com.example.korail_aos.data.entity.request

import kotlinx.serialization.Serializable

@Serializable
data class TicketRequest(
    val userId: Int,
    val ticketId: Int,
    val seat: String,
    val cabin: Int
)
