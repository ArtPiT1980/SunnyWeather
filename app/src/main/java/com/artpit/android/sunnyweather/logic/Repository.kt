package com.artpit.android.sunnyweather.logic

import androidx.lifecycle.liveData
import com.artpit.android.sunnyweather.logic.dao.PlaceDao
import com.artpit.android.sunnyweather.logic.model.Place
import com.artpit.android.sunnyweather.logic.model.Weather
import com.artpit.android.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.awaitResponse
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

object Repository {
//    fun searchPlaces(text: String) = liveData(Dispatchers.IO) {
//        val result = try {
//            val placeResponse = SunnyWeatherNetwork.searchPlaces(text)
//
//            if (placeResponse.locations.isNotEmpty()) {
//                Result.success(placeResponse)
//            } else {
//                Result.failure(RuntimeException("response status is ${placeResponse.locations.size}"))
//            }
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//
//        emit(result)
//    }

//    fun refreshWeather(id: Long) = liveData(Dispatchers.IO) {
//        val result = try {
//            coroutineScope {
//                val deferredCurrentWeather = async {
//                    SunnyWeatherNetwork.getCurrentWeather(id)
//                }
//
//                val deferredDailyWeather = async {
//                    SunnyWeatherNetwork.getDailyWeather(id)
//                }
//
//                val currentWeatherResponse = deferredCurrentWeather.await()
//                val dailyWeatherResponse = deferredDailyWeather.await()
//
//                if (currentWeatherResponse.isExecuted && dailyWeatherResponse.isExecuted) {
//                    //val weather = Weather(currentWeatherResponse, dailyWeatherResponse)
//                    val weather = true
//                    Result.success(weather)
//                } else {
//                    Result.failure(
//                        RuntimeException("current response status is null" +
//                                "daily response status is null"
//                        )
//                    )
//                }
//            }
//        } catch (e: Exception) {
//            Result.failure<Weather>(e)
//        }
//        emit(result)
//    }

    fun searchPlaces(text: String) = getData(Dispatchers.IO) {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(text)

            if (placeResponse.locations.isNotEmpty()) {
                Result.success(placeResponse)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.locations.size}"))
            }
    }

    fun refreshWeather(id: String) = getData(Dispatchers.IO) {
        coroutineScope {
            val deferredCurrentWeather = async {
                SunnyWeatherNetwork.getCurrentWeather(id)
            }

            val deferredDailyWeather = async {
                SunnyWeatherNetwork.getDailyWeather(id)
            }

            val currentWeatherResponse = deferredCurrentWeather.await()
            val dailyWeatherResponse = deferredDailyWeather.await()

            if (deferredCurrentWeather.isCompleted && deferredCurrentWeather.isCompleted) {
//                val currentWeatherResponse = deferredCurrentWeather.await()
//                val dailyWeatherResponse = deferredDailyWeather.await()

                val weather = Weather(
                    currentWeatherResponse.current,
                    dailyWeatherResponse.forecast
                )

                Result.success(weather)
            } else {
                Result.failure(
                    RuntimeException(
                        "current response status is null" +
                                "daily response status is null"
                    )
                )
            }
        }
    }

    private fun<T> getData(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }

            emit(result)
        }

    fun savePlace(place: Place) = PlaceDao.savePlace(place)

    fun getSavedPlace() = PlaceDao.getSavedPlace()

    fun isPlaceSaved() = PlaceDao.isPlaceSaved()
}