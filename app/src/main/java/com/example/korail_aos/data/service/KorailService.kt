package com.example.korail_aos.data.service

import com.example.korail_aos.data.entity.request.TicketRequest
import com.example.korail_aos.data.entity.response.ResponseUserTicketDto
import com.example.korail_aos.remote.ResponseMainDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface KorailService {
    @POST("api/ticket")
    suspend fun postTicket(
        @Body body: TicketRequest
    )

    @GET("/api/ticket")
    fun getTicket(): Call<ResponseMainDto>

    @GET("api/ticket/user/{userId}")
    fun getUserTicket(
        @Path("userId") userId: Int
    ): Call<ResponseUserTicketDto>
}
