package com.example.korail_aos.data.entity.response

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

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
        @Contextual
        val startDate: Date,
        @SerialName("endDate")
        @Contextual
        val endDate: Date,
        @SerialName("name")
        val name: String,
        @SerialName("gender")
        val gender: String,
        @SerialName("birth")
        @Contextual
        val birth: Date,
        @SerialName("ticketNum")
        val ticketNum: String,
        @SerialName("currentDate")
        @Contextual
        val currentDate: Date
    )
}
