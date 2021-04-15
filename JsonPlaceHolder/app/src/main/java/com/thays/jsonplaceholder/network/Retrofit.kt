package com.thays.jsonplaceholder.network

import com.thays.jsonplaceholder.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object Retrofit {

    private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.writeTimeout(30, TimeUnit.SECONDS)

        retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    open fun getApi(): Api? {
        return getRetrofit().create(Api::class.java)
    }
}
