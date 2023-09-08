package com.artpit.android.sunnyweather.ui.weather

import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.artpit.android.sunnyweather.R
import com.artpit.android.sunnyweather.databinding.ActivityWeatherBinding
import com.artpit.android.sunnyweather.databinding.ForecastBinding
import com.artpit.android.sunnyweather.databinding.ForecastItemBinding
import com.artpit.android.sunnyweather.databinding.LifeIndexBinding
import com.artpit.android.sunnyweather.databinding.NowBinding
import com.artpit.android.sunnyweather.logic.model.Weather
import com.artpit.android.sunnyweather.logic.model.getSky
import com.google.android.material.card.MaterialCardView
import java.util.Locale

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding
    private lateinit var forecastBinding: ForecastBinding
    private lateinit var lifeIndexBinding: LifeIndexBinding
    private lateinit var forecastItemBinding: ForecastItemBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWeatherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        forecastBinding = ForecastBinding.inflate(layoutInflater)
        lifeIndexBinding = LifeIndexBinding.inflate(layoutInflater)
        forecastItemBinding = ForecastItemBinding.inflate(layoutInflater)

        if (viewModel.locationLng.isEmpty()) {
            viewModel.locationLng = intent.getStringExtra("location_lng") ?: ""
        }

        if (viewModel.locationLat.isEmpty()) {
            viewModel.locationLat = intent.getStringExtra("location_lat") ?: ""
        }

        if (viewModel.placeName.isEmpty()) {
            viewModel.placeName = intent.getStringExtra("place_name") ?: ""
        }

        if (viewModel.id.isEmpty()) {
            viewModel.id = intent.getStringExtra("id") ?: ""
        }

        viewModel.weatherLiveData.observe(this, Observer { result ->
            val weather = result.getOrNull()

            if (weather != null) {
                showWeatherInfo(weather)
            } else {
                Toast.makeText(this, "Failed to get weather data",
                    Toast.LENGTH_SHORT).show()

                result.exceptionOrNull()?.printStackTrace()
            }
        })

        viewModel.refreshWeather(
            viewModel.id,
            viewModel.locationLng,
            viewModel.locationLat
        )
    }

    private fun showWeatherInfo(weather: Weather) {
        val placeName = findViewById<TextView>(R.id.placeName)
        val currentTemp = findViewById<TextView>(R.id.currentTemp)
        val currentSky = findViewById<TextView>(R.id.currentSky)
        val currentAQI = findViewById<TextView>(R.id.currentAQI)

        val coldRiskText = findViewById<TextView>(R.id.coldRiskText)
        val dressingText = findViewById<TextView>(R.id.dressingText)
        val ultravioletText = findViewById<TextView>(R.id.ultravioletText)
        val carWashingText = findViewById<TextView>(R.id.carWashingText)

        val nowLayout = findViewById<RelativeLayout>(R.id.nowL)
        val forecastLayout = findViewById<MaterialCardView>(R.id.forecastL)
        val lifeIndexLayout = findViewById<MaterialCardView>(R.id.lifeIndexL)

        placeName.text = viewModel.placeName

        val currentWeather = weather.currentWeather
        val dailyWeather = weather.dailyWeather

        val currentTempText = "${currentWeather.temperature} C"
        currentTemp.text = currentTempText
//        currentSky.text = getSky(currentWeather.relHumidity)
        currentSky.text = getSky(currentWeather.symbol).info

        val currentPM25Text = "Air quality Index ${currentWeather.relHumidity}"
        currentAQI.text = currentPM25Text
//        nowBinding.nowLayout.setBackgroundResource(getSky(currentWeather.))
        nowLayout.setBackgroundResource(getSky(currentWeather.symbol).bg)

        forecastLayout.removeAllViews()
        val days = dailyWeather.size

        for (i in 0 until days) {
            val skycon = dailyWeather[i]
            val temperature = (dailyWeather[i].maxTemp + dailyWeather[i].minTemp) / 2
            val view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false)
            val dateInfo = view.findViewById(R.id.dateInfo) as TextView
            val skyIcon = view.findViewById(R.id.skyIcon) as ImageView
            val skyInfo = view.findViewById(R.id.skyInfo) as TextView
            val temperatureInfo = view.findViewById(R.id.temperatureInfo) as TextView
//            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//            dateInfo.text = simpleDateFormat.format(skycon.date)
            dateInfo.text = skycon.date
            val sky = getSky(skycon.symbol)
            skyIcon.setImageResource(sky.icon)
            skyInfo.text = sky.info
            val tempText = "${dailyWeather[i].minTemp} ~ ${dailyWeather[i].maxTemp} ℃"
            temperatureInfo.text = tempText
            forecastLayout.addView(view)
        }

        val lifeIndex = dailyWeather[0]
        coldRiskText.text = lifeIndex.confidence
        dressingText.text = lifeIndex.symbol
        ultravioletText.text = lifeIndex.cloudiness.toString()
        carWashingText.text = lifeIndex.maxRelHumidity.toString()
        binding.weatherLayout.visibility = View.VISIBLE
    }
}