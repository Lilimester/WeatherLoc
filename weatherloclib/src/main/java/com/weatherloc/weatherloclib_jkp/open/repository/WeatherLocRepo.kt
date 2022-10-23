package com.weatherloc.weatherloclib_jkp.open.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient
import com.weatherloc.weatherloclib_jkp.open.utils.securedCallsOfApi
import kotlinx.coroutines.*

/**
 * A class which contains the Network call and observer instances containing the network call data.
 * */
internal class WeatherLocRepo {

    /**
     * This variable is the initialization for the WeatherLocApi which would be forged
     * with the initialization of the web client.
     * */
    private val mApiService = WebApiClient.initiateWeatherLocApi

    /**
     * This is the general variable for containing the thrown exceptions.
     * */
    var mException = Exception()

    /**
     * Observable instance which contains live data of type [CurrentWeatherData] further deep dive of
     * this object is available on WeatherLoc class's obtainCurrentWeatherByLatLng method.
     *
     * this observable is only available for the module as call backs would carry out the data for
     * current weather.
     * */
    val mLatLngCurrentResponse: MutableLiveData<CurrentWeatherData?> = MutableLiveData()

    /**
     * This method would lunch the network call for current weather details through coroutine scope.
     * */
    fun getWeatherFromLatLng(lat:Double, lng:Double, unitPreference: TemperatureUnitType? = null){
        CoroutineScope(Dispatchers.IO).launch {
            doGetWeatherFromLatLng(lat, lng, unitPreference)
        }
    }

    /**
     * This method would set either successful value of the instance is network call succeeds or exception
     * if the network call fails.
     * */
    private fun doGetWeatherFromLatLng(lat:Double, lng:Double, unitPreference: TemperatureUnitType? = null) {
        securedCallsOfApi({
            Log.e("WeatherLoc === ",it.message.toString())
            mLatLngCurrentResponse.postValue(null)
            mException = it
        }){
            mApiService.getWeatherConditionByLatLng(lat, lng, unitPreference).apply {
                mLatLngCurrentResponse.postValue(this)
            }
        }
    }

    /**
     * Observable instance which contains live data of type [FutureWeatherData] further deep dive of
     * this object is available on WeatherLoc class's obtainFutureWeatherByLatLng method.
     *
     * this observable is only available for the module as call backs would carry out the data for
     * current weather.
     * */
    val mLatLngFutureResponse: MutableLiveData<FutureWeatherData?> = MutableLiveData()

    /**
     * This method would lunch the network call for future's specified day's weather details through
     * coroutine scope.
     * */
    fun getWeatherFromLatLngForFuture(lat:Double, lng:Double, dayCount: Int, unitPreference: TemperatureUnitType? = null){
        CoroutineScope(Dispatchers.IO).launch {
            doGetWeatherFromLatLngForFuture(lat, lng,dayCount, unitPreference)
        }
    }

    /**
     * This method would set either successful value of the instance is network call succeeds or exception
     * if the network call fails.
     * */
    private fun doGetWeatherFromLatLngForFuture(lat:Double, lng:Double, dayCount: Int, unitPreference: TemperatureUnitType? = null) {
        securedCallsOfApi({
            Log.e("WeatherLoc === ",it.message.toString())
            mLatLngFutureResponse.postValue(null)
            mException = it
        }){
            mApiService.getWeatherConditionByLatLngForFuture(lat, lng, dayCount, unitPreference).apply {
                mLatLngFutureResponse.postValue(this)
            }
        }
    }

    /**
     * Observable instance which contains live data of type [FutureWeatherData] further deep dive of
     * this object is available on WeatherLoc class's obtainFiveDaysWeatherFromLatLng method.
     *
     * this observable is only available for the module as call backs would carry out the data for
     * current weather.
     * */

    val mLatLngFiveDaysResponse: MutableLiveData<FutureWeatherData?> = MutableLiveData()

    /**
     * This method would lunch the network call for 5 days weather details through coroutine scope.
     * */
    fun getWeatherFromLatLngForFiveDays(lat:Double, lng:Double, unitPreference: TemperatureUnitType? = null){
        CoroutineScope(Dispatchers.IO).launch {
            doGetWeatherFromLatLngForFiveDays(lat, lng, unitPreference)
        }
    }

    /**
     * This method would set either successful value of the instance is network call succeeds or exception
     * if the network call fails.
     * */
    private fun doGetWeatherFromLatLngForFiveDays(lat:Double, lng:Double, unitPreference: TemperatureUnitType? = null) {
        securedCallsOfApi({
            Log.e("WeatherLoc === ",it.message.toString())
            mLatLngFiveDaysResponse.postValue(null)
            mException = it
        }){
            mApiService.getWeatherConditionByLatLngForFiveFutureDays(lat, lng, unitPreference).apply {
                mLatLngFiveDaysResponse.postValue(this)
            }
        }
    }
}