package com.artpit.android.sunnyweather.logic

import androidx.lifecycle.liveData
import com.artpit.android.sunnyweather.logic.model.Place
import com.artpit.android.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

object Repository {
    fun searchPlaces(text: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(text)

            if (placeResponse.locations.size > 0) {
                Result.success(placeResponse)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.locations.size}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

        emit(result)
    }
}