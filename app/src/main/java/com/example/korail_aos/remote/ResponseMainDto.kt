package com.example.korail_aos.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class ResponseMainDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Data> // 배열로 들어가는 형식이기에 list로 만들어 줘야 한다.
) {
    @Serializable
    data class Data(
        @SerialName("ticket_id")
        val ticket_id: Int,
        @SerialName("from")
        val from: String,
        @SerialName("to")ㄴ
        val to: String,
        @SerialName("date")
        val date: String,
        @SerialName("seat_num")
        val seat_num: Int,
        @SerialName("trail")
        val trail: String
    )
}
