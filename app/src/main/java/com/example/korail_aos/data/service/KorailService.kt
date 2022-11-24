package com.example.korail_aos.data.service

import com.example.korail_aos.data.entity.response.ResponseUserTicketDTO
import retrofit2.Call
import retrofit2.http.Path

interface KorailService {
    fun getUserTicket(
        @Path("userId") userId: Int
    ): Call<ResponseUserTicketDTO>
}
