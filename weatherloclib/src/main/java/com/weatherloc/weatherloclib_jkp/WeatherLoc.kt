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

class WeatherLoc(private val mContext: Context, private val mUnitType:TemperatureUnitType? = null) : OpenWeatherLocCaller() {

   /**
    * below function checkes for the connectivity of the internet.
    *
    * Parameters: Context - Interface to global information about an application environment.  This is
    *                       an abstract class whose implementation is provided by
    *                       the Android system.  It
    *                       allows access to application-specific resources and classes, as well as
    *                       up-calls for application-level operations such as launching activities,
    *                       broadcasting and receiving intents, etc.
    *
    * Result: true - This value is returned when network connectivity is available.
    *         false - This value is returned when network connectivity is not available.
    */

    @RequiresApi(Build.VERSION_CODES.M)
    fun isInternetAvailable(context: Context):Boolean{
        val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isAvailable && networkInfo.isConnected
    }

   /**
    * Below function fetches the weather data for current time based on the latitude and longitude.
    *
    * The inner implementation is based on the coroutine hence can be called from any view classes
    * without putting burden to the main thread.
    *
    * Parameters:
    *
    * lifecycleOwner - A class that has an Android lifecycle. These events can be used by custom
    * components to handle lifecycle changes without implementing any code inside the Activity or
    * the Fragment.
    *
    * lat - Double datatype value of Latitude.
    *
    * lng - Double datatype value of Longitude.
    *
    * successBlock - A method callback that provides the end result of weather data. weather data
    * object has multiple properties through which data can be obtained.
    *
    * objects parameters are as follows.
    *
    *   weather -
    *       coord -
    *           coord.lon - City geo location, longitude
    *           coord.lat - City geo location, latitude
    *
    *       weather -
    *           weather.id - Weather condition id
    *           weather.main_weather - Group of weather parameters (Rain, Snow, Extreme etc.)
    *           weather.description - Weather condition within the group. You can get the output in your language. Learn more
    *           weather.icon Weather icon id
    *
    *       base - Internal parameter
    *
    *       main -
    *           main.temp - Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.feels_like - Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.pressure - Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
    *           main.humidity - Humidity, %
    *           main.temp_min - Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.temp_max - Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.sea_level - Atmospheric pressure on the sea level, hPa
    *           main.grnd_level - Atmospheric pressure on the ground level, hPa
    *
    *       visibility - Visibility, meter. The maximum value of the visibility is 10km
    *
    *       wind -
    *           wind.speed - Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
    *           wind.deg - Wind direction, degrees (meteorological)
    *           wind.gust - Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    *
    *       clouds -
    *           clouds.all - Cloudiness, %
    *
    *       rain -
    *           rain.oneHour - Rain volume for the last 1 hour, mm
    *           rain.threeHours - Rain volume for the last 3 hours, mm
    *
    *       snow -
    *           snow.oneHour - Snow volume for the last 1 hour, mm
    *           snow.threeHours - Snow volume for the last 3 hours, mm
    *
    *       dt - Time of data calculation, unix, UTC
    *
    *       sys -
    *           sys.type - Internal parameter
    *           sys.id - Internal parameter
    *           sys.message - Internal parameter
    *           sys.country - Country code (GB, JP etc.)
    *           sys.sunrise - Sunrise time, unix, UTC
    *           sys.sunset - Sunset time, unix, UTC
    *
    *       timezone - Shift in seconds from UTC
    *
    *       id - City ID. Please note that built-in geocoder functionality has been deprecated. Learn more here.
    *
    *       name - City name. Please note that built-in geocoder functionality has been deprecated. Learn more here.
    *
    *       cod - Internal parameter
    *
    */
    fun obtainCurrentWeatherByLatLng(
        lifecycleOwner: LifecycleOwner,
        lat: Double,
        lng: Double,
        successBlock: (weather: CurrentWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit
    ) {
        if(isInternetAvailable(mContext)) {
            obtainCurrentWeatherFromLatLng(
                lifecycleOwner,
                lat,
                lng,
                successBlock,
                failureBlock,
                mUnitType
            )
        } else {
            val exception: Exception = Exception("Internet is not available!")
            failureBlock.invoke(exception)
        }
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

        fun convertKelvinToCelsius(value: Double):Double {
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