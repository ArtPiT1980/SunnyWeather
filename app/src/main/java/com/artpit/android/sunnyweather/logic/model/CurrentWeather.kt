package com.artpit.android.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("cloudiness")
    val cloudiness: Int,
    @SerializedName("dewPoint")
    val dewPoint: Int,
    @SerializedName("feelsLikeTemp")
    val feelsLikeTemp: Int,
    @SerializedName("precipProb")
    val precipProb: Int,
    @SerializedName("precipRate")
    val precipRate: Int,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("relHumidity")
    val relHumidity: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("symbolPhrase")
    val symbolPhrase: String,
    @SerializedName("temperature")
    val temperature: Int,
    @SerializedName("thunderProb")
    val thunderProb: Int,
    @SerializedName("time")
    val time: String,
    @SerializedName("uvIndex")
    val uvIndex: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("windDir")
    val windDir: Int,
    @SerializedName("windDirString")
    val windDirString: String,
    @SerializedName("windGust")
    val windGust: Int,
    @SerializedName("windSpeed")
    val windSpeed: Int
)