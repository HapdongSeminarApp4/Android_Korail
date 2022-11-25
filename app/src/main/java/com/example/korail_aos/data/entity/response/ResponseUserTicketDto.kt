package com.example.korail_aos.data.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserTicketDto(
    val status: Int,
    val message: String,
    val data: List<Ticket>
) {
    @Serializable
    data class Ticket(
        val ticketId: Int,
        val startDate: String,
        val endDate: String,
        val name: String,
        val gender: String,
        val birth: String,
        val ticketNum: String,
        val currentDate: String
    )
}
