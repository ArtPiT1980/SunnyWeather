package com.artpit.android.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val API_KEY = "94135e3fadmsh6ff0c0ddbe1e432p12a8acjsna972829c1426"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}