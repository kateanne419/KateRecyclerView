package com.example.katerecyclerview.common

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object CommonServiceLocator {

    // Logging Interceptor
    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    // OkHttp Instance
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    // Retrofit Instance
    private val contentType = "application/json".toMediaType()
    val service = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()
}