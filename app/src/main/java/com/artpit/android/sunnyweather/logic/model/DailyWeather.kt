package com.artpit.android.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class DailyWeather(
    @SerializedName("cloudiness")
    val cloudiness: Int,
    @SerializedName("confidence")
    val confidence: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("maxDewPoint")
    val maxDewPoint: Int,
    @SerializedName("maxFeelsLikeTemp")
    val maxFeelsLikeTemp: Int,
    @SerializedName("maxRelHumidity")
    val maxRelHumidity: Int,
    @SerializedName("maxTemp")
    val maxTemp: Int,
    @SerializedName("maxWindGust")
    val maxWindGust: Int,
    @SerializedName("maxWindSpeed")
    val maxWindSpeed: Int,
    @SerializedName("minDewPoint")
    val minDewPoint: Int,
    @SerializedName("minFeelsLikeTemp")
    val minFeelsLikeTemp: Int,
    @SerializedName("minRelHumidity")
    val minRelHumidity: Int,
    @SerializedName("minTemp")
    val minTemp: Int,
    @SerializedName("minVisibility")
    val minVisibility: Int,
    @SerializedName("moonPhase")
    val moonPhase: Int,
    @SerializedName("moonrise")
    val moonrise: String,
    @SerializedName("moonset")
    val moonset: String,
    @SerializedName("precipAccum")
    val precipAccum: Double,
    @SerializedName("precipProb")
    val precipProb: Int,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("snowAccum")
    val snowAccum: Int,
    @SerializedName("solarRadiationSum")
    val solarRadiationSum: Int,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunriseEpoch")
    val sunriseEpoch: Int,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("sunsetEpoch")
    val sunsetEpoch: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("symbolPhrase")
    val symbolPhrase: String,
    @SerializedName("uvIndex")
    val uvIndex: Int,
    @SerializedName("windDir")
    val windDir: Int
)

