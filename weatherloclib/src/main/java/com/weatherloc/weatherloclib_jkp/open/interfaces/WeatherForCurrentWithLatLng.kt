package com.weatherloc.weatherloclib_jkp.open.interfaces

import com.weatherloc.weatherloclib_jkp.open.models.WeatherLatLngResponse

interface WeatherForCurrentWithLatLng {
    fun currentWeatherCondition(weather: WeatherLatLngResponse?)
}