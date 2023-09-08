package com.artpit.android.sunnyweather.logic.model

data class Place(
    val id: String,
    val name: String,
    val country: String,
    val timezone: String,
    val language: String,
    val adminArea: String,
    val adminArea2: String,
    val adminArea3: String?,
    val lon: String,
    val lat: String
)