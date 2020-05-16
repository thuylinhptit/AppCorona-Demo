package com.example.appcorona

import com.google.gson.annotations.SerializedName

data class CoronaCountry(
    @SerializedName ( "updated") val updated: String,
    @SerializedName ( "country") val country: String,
    @SerializedName ( "countryInfo") val contryInfo: CountryInfo,
    @SerializedName ( "cases") val cases: Int,
    @SerializedName ( "todayCase") val todayCase: Int,
    @SerializedName ( "deaths") val deaths: Int,
    @SerializedName ( "todayDeaths") val todayDeaths: Int,
    @SerializedName ( "recovered") val recovered: Int,
    @SerializedName ( "active") val active: Int,
    @SerializedName ( "critical") val critical: Int,
    @SerializedName ("casesPerOneMillion") val casesPerOneMillion: Int,
    @SerializedName( "deathsPerOneMillion") val deathsPerOneMillion: Int,
    @SerializedName ("tests") val tests: Int,
    @SerializedName ("testsPerOneMillion") val testsPerOneMillion: Int,
    @SerializedName ("continent") val continent: String

    )