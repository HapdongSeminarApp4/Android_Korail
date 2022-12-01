package com.example.korail_aos.di

import androidx.databinding.ktx.BuildConfig
import com.example.korail_aos.BuildConfig.BASE_URL
import com.example.korail_aos.data.service.KorailService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun providesInterceptor(): Interceptor =
        Interceptor { chain ->
            with(chain) {
                proceed(
                    request()
                        .newBuilder()
                        .build()
                )
            }
        }

    @Provides
    @Singleton
    fun providesKorailOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(
                HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }
            )
            .build()

    @Provides
    @Singleton
    fun providesKorailRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun providesKorailService(retrofit: Retrofit): KorailService =
        retrofit.create(KorailService::class.java)
}
