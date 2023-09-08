package com.artpit.android.sunnyweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artpit.android.sunnyweather.ui.weather.WeatherActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, WeatherActivity::class.java).apply {
//            putExtra("location_lng", "0")
//            putExtra("location_lat", "0")
//            putExtra("place_name", "Odessa")
//            putExtra("id", "100698740")
//        }
//
//        startActivity(intent)
    }
}