package com.example.korail_aos.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserTicketDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Ticket>
) {
    @Serializable
    data class Ticket(
        @SerialName("ticketId")
        val ticketId: Int,
        @SerialName("startDate")
        val startDate: String,
        @SerialName("endDate")
        val endDate: String,
        @SerialName("name")
        val name: String,
        @SerialName("gender")
        val gender: String,
        @SerialName("birth")
        val birth: String,
        @SerialName("ticketNum")
        val ticketNum: String,
        @SerialName("currentDate")
        val currentDate: String
    )
}
