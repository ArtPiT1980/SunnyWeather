package com.artpit.android.sunnyweather.logic.model

import com.artpit.android.sunnyweather.R

class Sky(val info: String, val icon: Int, val bg: Int)

private val sky = mapOf(
//Day
    "d000" to Sky("Clear", R.drawable.d000, R.drawable.bg_clear_day),
    "d100" to Sky("Mostly clear", R.drawable.d100, R.drawable.bg_clear_day),
    "d200" to Sky("Partly cloudy", R.drawable.d200, R.drawable.bg_partly_cloudy_day),
    "d300" to Sky("Cloudy", R.drawable.d300, R.drawable.bg_partly_cloudy_day),
    "d400" to Sky("Overcast", R.drawable.d400, R.drawable.bg_cloudy),
    "d500" to Sky("Thin upper cloud", R.drawable.d500, R.drawable.bg_partly_cloudy_day),
    "d600" to Sky("Fog", R.drawable.d600, R.drawable.bg_fog),

    "d210" to Sky("Partly cloudy and light rain", R.drawable.d210, R.drawable.bg_rain),
    "d310" to Sky("Cloudy and light rain", R.drawable.d310, R.drawable.bg_rain),
    "d410" to Sky("Overcast and light rain", R.drawable.d410, R.drawable.bg_rain),

    "d220" to Sky("Partly cloudy and showers", R.drawable.d220, R.drawable.bg_rain),
    "d320" to Sky("Cloudy and showers", R.drawable.d320, R.drawable.bg_rain),
    "d420" to Sky("Overcast and showers", R.drawable.d420, R.drawable.bg_rain),

    "d430" to Sky("Overcast and rain", R.drawable.d430, R.drawable.bg_rain),

    "d240" to Sky("Partly cloudy, thunderstorms with rain", R.drawable.d240, R.drawable.bg_rain),
    "d340" to Sky("Cloudy, thunderstorms with rain", R.drawable.d340, R.drawable.bg_rain),
    "d440" to Sky("Overcast, thunderstorms with rain", R.drawable.d440, R.drawable.bg_rain),

    "d211" to Sky("Partly cloudy and light wet snow", R.drawable.d211, R.drawable.bg_snow),
    "d311" to Sky("Cloudy and light wet snow", R.drawable.d311, R.drawable.bg_snow),
    "d411" to Sky("Overcast and light wet snow", R.drawable.d411, R.drawable.bg_snow),

    "d221" to Sky("Partly cloudy and wet snow showers", R.drawable.d221, R.drawable.bg_snow),
    "d321" to Sky("Cloudy and wet snow showers", R.drawable.d321, R.drawable.bg_snow),
    "d421" to Sky("Overcast and wet snow showers", R.drawable.d421, R.drawable.bg_snow),

    "d431" to Sky("Overcast and wet snow", R.drawable.d431, R.drawable.bg_snow),

    "d212" to Sky("Partly cloudy and light snow", R.drawable.d212, R.drawable.bg_snow),
    "d312" to Sky("Cloudy and light snow", R.drawable.d312, R.drawable.bg_snow),
    "d412" to Sky("Overcast and light snow", R.drawable.d412, R.drawable.bg_snow),

    "d222" to Sky("Partly cloudy and snow showers", R.drawable.d222, R.drawable.bg_snow),
    "d322" to Sky("Cloudy and snow showers", R.drawable.d322, R.drawable.bg_snow),
    "d422" to Sky("Overcast and snow showers", R.drawable.d422, R.drawable.bg_snow),

    "d432" to Sky("Overcast and snow", R.drawable.d432, R.drawable.bg_snow),

//Night
    "n000" to Sky("Clear", R.drawable.n000, R.drawable.bg_clear_night),
    "n100" to Sky("Mostly clear", R.drawable.n100, R.drawable.bg_clear_night),
    "n200" to Sky("Partly cloudy", R.drawable.n200, R.drawable.bg_partly_cloudy_night),
    "n300" to Sky("Cloudy", R.drawable.n300, R.drawable.bg_partly_cloudy_night),
    "n400" to Sky("Overcast", R.drawable.n400, R.drawable.bg_cloudy),
    "n500" to Sky("Thin upper cloud", R.drawable.n500, R.drawable.bg_partly_cloudy_night),
    "n600" to Sky("Fog", R.drawable.n600, R.drawable.bg_fog),

    "n210" to Sky("Partly cloudy and light rain", R.drawable.n210, R.drawable.bg_rain),
    "n310" to Sky("Cloudy and light rain", R.drawable.n310, R.drawable.bg_rain),
    "n410" to Sky("Overcast and light rain", R.drawable.n410, R.drawable.bg_rain),

    "n220" to Sky("Partly cloudy and showers", R.drawable.n220, R.drawable.bg_rain),
    "n320" to Sky("Cloudy and showers", R.drawable.n320, R.drawable.bg_rain),
    "n420" to Sky("Overcast and showers", R.drawable.n420, R.drawable.bg_rain),

    "n430" to Sky("Overcast and rain", R.drawable.n430, R.drawable.bg_rain),

    "n240" to Sky("Partly cloudy, thunderstorms with rain", R.drawable.n240, R.drawable.bg_rain),
    "n340" to Sky("Cloudy, thunderstorms with rain", R.drawable.n340, R.drawable.bg_rain),
    "n440" to Sky("Overcast, thunderstorms with rain", R.drawable.n440, R.drawable.bg_rain),

    "n211" to Sky("Partly cloudy and light wet snow", R.drawable.n211, R.drawable.bg_snow),
    "n311" to Sky("Cloudy and light wet snow", R.drawable.n311, R.drawable.bg_snow),
    "n411" to Sky("Overcast and light wet snow", R.drawable.n411, R.drawable.bg_snow),

    "n221" to Sky("Partly cloudy and wet snow showers", R.drawable.n221, R.drawable.bg_snow),
    "n321" to Sky("Cloudy and wet snow showers", R.drawable.n321, R.drawable.bg_snow),
    "n421" to Sky("Overcast and wet snow showers", R.drawable.n421, R.drawable.bg_snow),

    "n431" to Sky("Overcast and wet snow", R.drawable.n431, R.drawable.bg_snow),

    "n212" to Sky("Partly cloudy and light snow", R.drawable.n212, R.drawable.bg_snow),
    "n312" to Sky("Cloudy and light snow", R.drawable.n312, R.drawable.bg_snow),
    "n412" to Sky("Overcast and light snow", R.drawable.n412, R.drawable.bg_snow),

    "n222" to Sky("Partly cloudy and snow showers", R.drawable.n222, R.drawable.bg_snow),
    "n322" to Sky("Cloudy and snow showers", R.drawable.n322, R.drawable.bg_snow),
    "n422" to Sky("Overcast and snow showers", R.drawable.n422, R.drawable.bg_snow),

    "n432" to Sky("Overcast and snow", R.drawable.n432, R.drawable.bg_snow),
)

fun getSky(skycon: String): Sky {
    return sky[skycon] ?: sky["CLEAR_DAY"]!!
}