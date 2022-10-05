package com.weatherloc.weatherloclib_jkp.open.repository

import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class WeatherLocRepo {
    private val mApiService = WebApiClient.initiateWeatherLocApi

    fun getWeatherFromLatLng(){
        GlobalScope.launch {

        }
    }

}