package com.example.em_database_web_patterns_practice.presentation.Task_3

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

fun main() = runBlocking {
    val client = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://echo.free.beeceptor.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(BeeceptorApi::class.java)

    try {
        val result = apiService.getResponse()
        println(result)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

class LoggingInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        val statusCode = response.code
        println("Server Response Code: $statusCode")
        return response
    }
}

interface BeeceptorApi {
    @GET("/")
    suspend fun getResponse(): Any
}