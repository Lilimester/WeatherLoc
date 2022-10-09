package com.weatherloc.weatherloclib_jkp.abstract

import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.WeatherLoc
import com.weatherloc.weatherloclib_jkp.open.OpenWeatherLocCaller
import com.weatherloc.weatherloclib_jkp.open.interfaces.WeatherForCurrentWithLatLng

abstract class Weather: OpenWeatherLocCaller() {
    abstract override fun obtainCurrentWeatherFromLatLng(lat:Double, lng:Double, weather: WeatherForCurrentWithLatLng)
}