package com.artpit.android.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class Place(
    val id: Long,
    val name: String,
    val country: String,
    val timezone: String,
    val language: String,
    val adminArea: String,
    val adminArea2: String,
    val adminArea3: String?,
    val lon: Double,
    val lat: Double
)