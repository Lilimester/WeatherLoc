package com.weatherloc.weatherloclib_jkp.open.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weatherloc.weatherloclib_jkp.open.models.WeatherData
import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient
import com.weatherloc.weatherloclib_jkp.open.utils.securedCallsOfApi
import kotlinx.coroutines.*

class WeatherLocRepo {
    private val mApiService = WebApiClient.initiateWeatherLocApi
    var mException = Exception()

    val mLatLngCurrentResponse: MutableLiveData<WeatherData?> = MutableLiveData()

    fun getWeatherFromLatLng(lat:Double, lng:Double){
        CoroutineScope(Dispatchers.IO).launch {
            doGetWeatherFromLatLng(lat, lng)
        }
    }

    private fun doGetWeatherFromLatLng(lat:Double, lng:Double) {
        securedCallsOfApi({
            Log.e("WeatherLoc === ",it.message.toString())
            mLatLngCurrentResponse.postValue(null)
            mException = it
        }){
            mApiService.getWeatherConditionByLatLng(lat, lng).apply {
                mLatLngCurrentResponse.postValue(this)
            }
        }
    }
}