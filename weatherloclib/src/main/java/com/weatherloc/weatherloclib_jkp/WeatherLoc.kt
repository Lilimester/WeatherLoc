package com.weatherloc.weatherloclib_jkp

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.open.OpenWeatherLocCaller
import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.utils.DayRange

class WeatherLoc(private val mUnitType:TemperatureUnitType? = null) : OpenWeatherLocCaller() {

    @RequiresApi(Build.VERSION_CODES.M)
    fun isInternetAvailable(context: Context):Boolean{
        val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isAvailable && networkInfo.isConnected
    }

    fun obtainCurrentWeatherByLatLng(
        lifecycleOwner: LifecycleOwner,
        lat: Double,
        lng: Double,
        successBlock: (weather: CurrentWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit
    ) {
        obtainCurrentWeatherFromLatLng(lifecycleOwner, lat, lng, successBlock, failureBlock, mUnitType)
    }

    fun obtainFutureWeatherByLatLng(
        lifecycleOwner: LifecycleOwner,
        lat: Double,
        lng: Double,
        dayRange: DayRange,
        successBlock: (weather: CurrentWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit
    ) {
        obtainFutureWeatherFromLatLng(lifecycleOwner, lat, lng, dayRange, successBlock, failureBlock, mUnitType)
    }

    companion object{
        val instance = WeatherLoc()
        val instanceWithStandardUnit = WeatherLoc(TemperatureUnitType.STANDARD)
        val instanceWithMetricUnit = WeatherLoc(TemperatureUnitType.METRIC)
        val instanceWithImperialUnit = WeatherLoc(TemperatureUnitType.IMPERIAL)

        fun convertKelvinToCelsius(value: Double):Double{
            return value - 273.15
        }

        fun convertKelvinToFahrenheit(value: Double):Double{
            return (convertKelvinToCelsius(value)) * 9 / 5 + 32
        }

        fun convertCelsiusToKelvin(value: Double):Double {
            return value + 273.15
        }

        fun convertCelsiusToFahrenheit(value:Double):Double {
            return value * 9 / 5 + 32
        }

        fun convertFahrenheitToKelvin(value:Double):Double {
            return convertFahrenheitToCelsius(value) + 273.15
        }

        fun convertFahrenheitToCelsius(value:Double):Double {
            return (value - 32) * 5 / 9
        }

        fun convertMilePerHourToMeterPerSecond(value:Double):Double{
            return value / 2.237
        }

        fun convertMeterPerSecondToMilePerHour(value:Double):Double{
            return value * 2.237
        }
    }
}