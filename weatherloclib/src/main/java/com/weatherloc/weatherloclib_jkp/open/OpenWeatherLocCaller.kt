package com.weatherloc.weatherloclib_jkp.open

import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import com.weatherloc.weatherloclib_jkp.open.repository.WeatherLocRepo

internal class OpenWeatherLocCaller {

    /**
     * Initialization of instance for calling the methods of the repository.
     */
    private val weatherRepo = WeatherLocRepo()

    /**
     * This method fetches the data of weather for current time through latitude and longitude of
     * location.
     *
     * For parameter info, it has been provided over the calling method at WeatherLoc class.
     * Below class calls the network api and observes the response received from Api.
     *
     * On successful call it invokes the block wrote by the user and provides the data to user which
     * can be utilized as per user's need.
     *
     * On failure of call, it invokes the failureBlock, providing the user an exception about what went
     * wrong. It also invokes the block on which user can perform certain action if api call fails.
     */

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

    /**
     * This method fetches the data of weather for specified duration of time through latitude and
     * longitude of location.
     *
     * For parameter info, it has been provided over the calling method at WeatherLoc class.
     * Below class calls the network api and observes the response received from Api.
     *
     * On successful call it invokes the block wrote by the user and provides the data to user which
     * can be utilized as per user's need.
     *
     * On failure of call, it invokes the failureBlock, providing the user an exception about what went
     * wrong. It also invokes the block on which user can perform certain action if api call fails.
     */

    fun obtainFutureWeatherFromLatLng(
        lifecycleOwner: LifecycleOwner,
        lat:Double,
        lng:Double,
        dayCount: Int,
        block: (weather: FutureWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit,
        unitPreference: TemperatureUnitType? = null,
    ) {
        weatherRepo.mLatLngFutureResponse.observe(lifecycleOwner) {
            if (it != null) {
                block.invoke(it)
            } else {
                failureBlock.invoke(weatherRepo.mException)
            }
        }
        weatherRepo.getWeatherFromLatLngForFuture(lat, lng, dayCount, unitPreference)
    }

    /**
     * This method fetches the data of weather for 5 days through latitude and longitude of location.
     *
     * For parameter info, it has been provided over the calling method at WeatherLoc class.
     * Below class calls the network api and observes the response received from Api.
     *
     * On successful call it invokes the block wrote by the user and provides the data to user which
     * can be utilized as per user's need.
     *
     * On failure of call, it invokes the failureBlock, providing the user an exception about what went
     * wrong. It also invokes the block on which user can perform certain action if api call fails.
     */

    fun obtainFiveDaysWeatherFromLatLng(
        lifecycleOwner: LifecycleOwner,
        lat:Double,
        lng:Double,
        block: (weather: FutureWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit,
        unitPreference: TemperatureUnitType? = null,
    ) {
        weatherRepo.mLatLngFiveDaysResponse.observe(lifecycleOwner) {
            if (it != null) {
                block.invoke(it)
            } else {
                failureBlock.invoke(weatherRepo.mException)
            }
        }
        weatherRepo.getWeatherFromLatLngForFiveDays(lat, lng, unitPreference)
    }
}