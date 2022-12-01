package com.example.korail_aos.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class ResponseMainDto(
    @SerialName("status") val status: Int,
    @SerialName("message") val message: String,
    @SerialName("data") val data: Data // 배열로 들어가는 형식이기에 list로 만들어 줘야 한다.
) {
    @Serializable
    data class Data(
        @SerialName("tikcet_id") val ticketId: Int,
        @SerialName("from") val from: String,
        @SerialName("to") val to: String,
        @SerialName("date") val date: String,
        @SerialName("seat_num") val seatNum: Int,
        @SerialName("trail") val trail: String
    )
}
