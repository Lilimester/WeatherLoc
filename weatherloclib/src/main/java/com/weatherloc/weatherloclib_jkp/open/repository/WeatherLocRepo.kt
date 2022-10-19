package com.weatherloc.weatherloclib_jkp.open.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient
import com.weatherloc.weatherloclib_jkp.open.utils.DayRange
import com.weatherloc.weatherloclib_jkp.open.utils.securedCallsOfApi
import kotlinx.coroutines.*


internal class WeatherLocRepo {
    private val mApiService = WebApiClient.initiateWeatherLocApi
    var mException = Exception()

    val mLatLngCurrentResponse: MutableLiveData<CurrentWeatherData?> = MutableLiveData()

    fun getWeatherFromLatLng(lat:Double, lng:Double, unitPreference: TemperatureUnitType? = null){
        CoroutineScope(Dispatchers.IO).launch {
            doGetWeatherFromLatLng(lat, lng, unitPreference)
        }
    }

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

    val mLatLngFutureResponse: MutableLiveData<FutureWeatherData?> = MutableLiveData()

    fun getWeatherFromLatLngForFuture(lat:Double, lng:Double, dayRange: DayRange, unitPreference: TemperatureUnitType? = null,){
        CoroutineScope(Dispatchers.IO).launch {
            doGetWeatherFromLatLngForFuture(lat, lng,dayRange, unitPreference)
        }
    }

    private fun doGetWeatherFromLatLngForFuture(lat:Double, lng:Double, dayRange: DayRange, unitPreference: TemperatureUnitType? = null,) {
        securedCallsOfApi({
            Log.e("WeatherLoc === ",it.message.toString())
            mLatLngFutureResponse.postValue(null)
            mException = it
        }){
            mApiService.getWeatherConditionByLatLngForFuture(lat, lng, dayRange.id, unitPreference).apply {
                mLatLngFutureResponse.postValue(this)
            }
        }
    }
}