package com.example.videoplayer.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit



 open class BaseOkHttp {

    val NETWORK_CONNECTION_TIMEOUT = 15L

    /**
     * Provide OkHttpClient object with header
     */
     private fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .addInterceptor(provideBasicAuthInterceptor())
            .connectTimeout(NETWORK_CONNECTION_TIMEOUT, TimeUnit.SECONDS).build()
    }

    /**
     * Apply header to OkHttpClient chain request
     */
    private fun provideBasicAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder().addHeader("authorization", "Enter Api Key").build()
            chain.proceed(request)
        }
    }


    /**
     * Apply Logging Interceptor to OkHttpClient
     */
    private fun provideLoggingInterceptor(): LoggingInterceptor {
        val httpLoggingInterceptor = LoggingInterceptor()
        httpLoggingInterceptor.level = LoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}