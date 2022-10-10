package com.weatherloc.weatherloclib_jkp

import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.open.OpenWeatherLocCaller
import com.weatherloc.weatherloclib_jkp.open.models.WeatherData

class WeatherLoc : OpenWeatherLocCaller() {

    fun obtainCurrentWeatherByLatLng(
        lifecycleOwner: LifecycleOwner,
        lat: Double,
        lng: Double,
        successBlock: (weather: WeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit
    ) {
        obtainCurrentWeatherFromLatLng(lifecycleOwner, lat, lng, successBlock, failureBlock)
    }

    companion object{
        val instance = WeatherLoc()
    }
}