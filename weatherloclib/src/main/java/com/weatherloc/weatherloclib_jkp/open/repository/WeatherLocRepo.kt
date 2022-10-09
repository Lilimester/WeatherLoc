package com.weatherloc.weatherloclib_jkp.open.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weatherloc.weatherloclib_jkp.open.models.WeatherLatLngResponse
import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient
import com.weatherloc.weatherloclib_jkp.open.utils.securedCallsOfApi
import kotlinx.coroutines.*

class WeatherLocRepo {
    private val mApiService = WebApiClient.initiateWeatherLocApi

    val mLatLngCurrentResponse: MutableLiveData<WeatherLatLngResponse?> = MutableLiveData()

    fun getWeatherFromLatLng(lat:Double, lng:Double){
        CoroutineScope(Dispatchers.IO).launch {
            doGetWeahterFromLatLng(lat, lng)
        }
    }

    private fun doGetWeahterFromLatLng(lat:Double, lng:Double) {
        securedCallsOfApi({
            mLatLngCurrentResponse.value = null
            Log.e("WeatherLoc",it.message.toString())
        }){
            mApiService.getWeatherConditionByLatLng(lat, lng).apply {
                mLatLngCurrentResponse.value = this
            }
        }
    }
}