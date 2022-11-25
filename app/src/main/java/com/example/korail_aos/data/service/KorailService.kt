package com.example.korail_aos.data.service

import com.example.korail_aos.data.entity.request.TicketRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface KorailService {
    @POST("api/ticket")
    suspend fun postTicket(
        @Body body: TicketRequest
    )
}
