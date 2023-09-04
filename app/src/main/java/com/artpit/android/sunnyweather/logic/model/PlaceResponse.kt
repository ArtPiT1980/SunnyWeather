package com.artpit.android.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(
    @SerializedName("locations")
    val locations: List<Place>
)