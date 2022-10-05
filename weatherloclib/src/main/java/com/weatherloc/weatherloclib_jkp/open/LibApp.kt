package com.weatherloc.weatherloclib_jkp.open

import android.app.Application
import com.weatherloc.weatherloclib_jkp.open.interfaces.WeatherLocApi
import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient

class LibApp: Application() {

    lateinit var mApiService: WeatherLocApi

    override fun onCreate() {
        super.onCreate()
        mApiService = WebApiClient.initiateWeatherLocApi
    }
}