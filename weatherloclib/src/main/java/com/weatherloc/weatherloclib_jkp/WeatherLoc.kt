package com.weatherloc.weatherloclib_jkp

import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.abstract.Weather
import com.weatherloc.weatherloclib_jkp.open.interfaces.WeatherForCurrentWithLatLng

class WeatherLoc : Weather() {



    companion object{
        val instance = WeatherLoc() as Weather
    }

    override fun obtainCurrentWeatherFromLatLng(lat: Double, lng: Double, weather: WeatherForCurrentWithLatLng) {

    }
}