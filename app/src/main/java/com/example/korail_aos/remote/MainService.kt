package com.example.korail_aos.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainService {
    @GET("api/users?page=2")
    fun main(@Query("page") page: Int): Call<ResponseMainDTO>
}