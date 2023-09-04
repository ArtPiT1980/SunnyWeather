package com.artpit.android.sunnyweather.logic.network

import com.artpit.android.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface PlaceService {
    @Headers(
        "X-RapidAPI-Key: 355ba211bamsh4c2fdcbb39abac5p18fdc2jsn01e5656bae4e",
        "X-RapidAPI-Host: foreca-weather.p.rapidapi.com"
    )

    @GET("location/search/{query}")
    //fun searchPlaces(@Query("text") text: String): Call<PlaceResponse>
    fun searchPlaces(@Path("query") text: String, @Query("lang") lang: String = "ru"): Call<PlaceResponse>
}