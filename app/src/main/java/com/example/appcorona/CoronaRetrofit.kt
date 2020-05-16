package com.example.appcorona

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CoronaRetrofit {
    var instance : Retrofit? = null

    fun getRetrofit(): Retrofit{
        if( instance == null ){
            var client = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .callTimeout(10,TimeUnit.SECONDS)
                .build()

            instance = Retrofit.Builder()
                .baseUrl("https://corona.lmao.ninja/v2/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return  instance!!
    }

    fun getCoronaService(): CoronaServices{
        return  getRetrofit().create(CoronaServices :: class.java)
    }
}