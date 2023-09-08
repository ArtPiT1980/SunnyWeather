package com.artpit.android.sunnyweather.logic.network

import com.artpit.android.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PlaceService {
    @Headers(
        "X-RapidAPI-Key: 355ba211bamsh4c2fdcbb39abac5p18fdc2jsn01e5656bae4e",
        "X-RapidAPI-Host: foreca-weather.p.rapidapi.com"
    )
    @GET("location/search/{query}")
    fun searchPlaces(
        @Path("query")
        text: String,
    ): Call<PlaceResponse>

    @Headers(
        "X-RapidAPI-Key: 355ba211bamsh4c2fdcbb39abac5p18fdc2jsn01e5656bae4e",
        "X-RapidAPI-Host: foreca-weather.p.rapidapi.com"
    )
    @GET("location/search/{query}?lang={lang}")
    fun searchPlaces(
        @Path("query")
        text: String,
        @Path("lang")
        lang: String
    ): Call<PlaceResponse>

    @Headers(
        "X-RapidAPI-Key: 355ba211bamsh4c2fdcbb39abac5p18fdc2jsn01e5656bae4e",
        "X-RapidAPI-Host: foreca-weather.p.rapidapi.com"
    )
    @GET("location/search/{query}?lang={lang}&country={country}")
    fun searchPlaces(
        @Path("query")
        text: String,
        @Path("lang")
        lang: String = "en",
        @Path("country")
        country: String
    ): Call<PlaceResponse>
}