package com.artpit.android.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.artpit.android.sunnyweather.logic.Repository
import com.artpit.android.sunnyweather.logic.model.Location

class WeatherViewModel : ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    var id = ""

    val weatherLiveData = locationLiveData.switchMap { location ->
        Repository.refreshWeather(location.id)
    }

    fun refreshWeather(id: String, lon: String, lat: String) {
        locationLiveData.value = Location(id, lon, lat)
    }
}