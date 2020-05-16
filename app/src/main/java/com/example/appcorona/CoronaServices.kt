package com.example.appcorona

import retrofit2.Call
import retrofit2.http.GET

interface CoronaServices{
    @GET("countries")
    fun getAllCountryInfos(): Call<List<CoronaCountry>>
}