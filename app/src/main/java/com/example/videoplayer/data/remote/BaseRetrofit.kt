package com.example.videoplayer.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class BaseRetrofit {
    companion object {
        private var retrofit: Retrofit? = null
        private const val NETWORK_CONNECTION_TIMEOUT = 15L
        fun getRetrofit(): Retrofit {
            return retrofit ?: Retrofit.Builder()
                .baseUrl("https://interview-e18de.firebaseio.com/")
                .client(provideOKHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        /**
         * Provide OkHttpClient object with header
         */
        private fun provideOKHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(NETWORK_CONNECTION_TIMEOUT, TimeUnit.SECONDS).build()
        }
    }


}