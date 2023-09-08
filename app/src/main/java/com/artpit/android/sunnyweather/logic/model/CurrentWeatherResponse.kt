package com.artpit.android.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

class CurrentWeatherResponse(
    @SerializedName("current")
    val current: CurrentWeather
)