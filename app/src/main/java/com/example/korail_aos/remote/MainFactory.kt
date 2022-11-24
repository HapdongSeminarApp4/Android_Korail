package com.example.korail_aos.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object MainFactory {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://localhost:3000/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}
object MainServicePool {
    val mainService = MainFactory.create<MainService>()
}
