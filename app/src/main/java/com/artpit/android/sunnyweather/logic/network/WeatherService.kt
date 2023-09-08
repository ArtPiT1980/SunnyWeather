package com.artpit.android.sunnyweather.logic.network

import com.artpit.android.sunnyweather.logic.model.CurrentWeatherResponse
import com.artpit.android.sunnyweather.logic.model.DailyWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface WeatherService {
//    @GET("current/{id}?alt={alt}&tempunit{tempunit}&windunit{windunit}&lang{lang}")
//    fun getCurrentWeather(
//        @Path("id")
//        id: String,
//        @Path("alt")
//        alt: Int = 0,
//        @Path("tempunit")
//        tempUnit: String = "C",
//        @Path("windunit")
//        winUnit: String = "MS",
//        @Path("lang")
//        lang: String = ""
//    ): Call<CurrentWeatherResponse>

//    @GET("forecast/daily/{id}?alt={alt}&tempunit={tempunit}&windunit={windunit}&periods={periods}&dataset{dataset}")
//    fun getDailyWeather(
//        @Path("id")
//        id: String,
//        @Path("alt")
//        alt: String = "0",
//        @Path("tempunit")
//        tempUnit: String = "C",
//        @Path("windunit")
//        winUnit: String = "MS",
//        @Path("periods")
//        periods: Int = 5,
//        @Path("dataset")
//        dataset: String = "full"
//    ): Call<DailyWeatherResponse>

    @Headers(
        "X-RapidAPI-Key: 355ba211bamsh4c2fdcbb39abac5p18fdc2jsn01e5656bae4e",
        "X-RapidAPI-Host: foreca-weather.p.rapidapi.com"
    )
    @GET("current/{id}")
    fun getCurrentWeather(
        @Path("id")
        id: String,
    ): Call<CurrentWeatherResponse>

    @Headers(
        "X-RapidAPI-Key: 355ba211bamsh4c2fdcbb39abac5p18fdc2jsn01e5656bae4e",
        "X-RapidAPI-Host: foreca-weather.p.rapidapi.com"
    )
    @GET("forecast/daily/{id}?periods=8")
    fun getDailyWeather(
        @Path("id")
        id: String
    ): Call<DailyWeatherResponse>
}