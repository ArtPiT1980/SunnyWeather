package com.artpit.android.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

class DailyWeatherResponse(
    @SerializedName("forecast")
    val forecast: List<DailyWeather>
)