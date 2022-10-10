package com.weatherloc.weatherloclib_jkp.open

import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.open.models.WeatherData
import com.weatherloc.weatherloclib_jkp.open.repository.WeatherLocRepo


open class OpenWeatherLocCaller {

    private val weatherRepo = WeatherLocRepo()

    fun obtainCurrentWeatherFromLatLng(
        lifecycleOwner: LifecycleOwner,
        lat:Double,
        lng:Double,
        block: (weather:WeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit
    ) {
        weatherRepo.mLatLngCurrentResponse.observe(lifecycleOwner) {
            if (it != null) {
                block.invoke(it)
            } else {
                failureBlock.invoke(weatherRepo.mException)
            }
        }
        weatherRepo.getWeatherFromLatLng(lat, lng)
    }
}