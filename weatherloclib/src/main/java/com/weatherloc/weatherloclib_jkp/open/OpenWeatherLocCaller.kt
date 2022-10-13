package com.weatherloc.weatherloclib_jkp.open

import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.repository.WeatherLocRepo
import com.weatherloc.weatherloclib_jkp.open.utils.DayRange


open class OpenWeatherLocCaller {

    private val weatherRepo = WeatherLocRepo()

    fun obtainCurrentWeatherFromLatLng(
        lifecycleOwner: LifecycleOwner,
        lat:Double,
        lng:Double,
        block: (weather: CurrentWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit,
        unitPreference: TemperatureUnitType? = null,
    ) {
        weatherRepo.mLatLngCurrentResponse.observe(lifecycleOwner) {
            if (it != null) {
                block.invoke(it)
            } else {
                failureBlock.invoke(weatherRepo.mException)
            }
        }
        weatherRepo.getWeatherFromLatLng(lat, lng, unitPreference)
    }


    fun obtainFutureWeatherFromLatLng(
        lifecycleOwner: LifecycleOwner,
        lat:Double,
        lng:Double,
        dayRange: DayRange,
        block: (weather: CurrentWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit,
        unitPreference: TemperatureUnitType? = null,
    ) {
        weatherRepo.mLatLngCurrentResponse.observe(lifecycleOwner) {
            if (it != null) {
                block.invoke(it)
            } else {
                failureBlock.invoke(weatherRepo.mException)
            }
        }
        weatherRepo.getWeatherFromLatLngForFuture(lat, lng, dayRange, unitPreference)
    }
}