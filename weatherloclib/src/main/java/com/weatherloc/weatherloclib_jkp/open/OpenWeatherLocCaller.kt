package com.weatherloc.weatherloclib_jkp.open

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.weatherloc.weatherloclib_jkp.open.interfaces.WeatherForCurrentWithLatLng
import com.weatherloc.weatherloclib_jkp.open.repository.WeatherLocRepo


open class OpenWeatherLocCaller {

    private val weatherRepo = WeatherLocRepo()

    private val mLifecycleOwner = object : LifecycleOwner{
        override fun getLifecycle(): Lifecycle {
            val mLifecycleRegistry = LifecycleRegistry(this)
            mLifecycleRegistry.currentState = Lifecycle.State.CREATED
            return mLifecycleRegistry
        }
    }

    open fun obtainCurrentWeatherFromLatLng(lat:Double, lng:Double, weather: WeatherForCurrentWithLatLng) {
        weatherRepo.mLatLngCurrentResponse.observe(mLifecycleOwner,{
            if(it!=null){
                weather.currentWeatherCondition(it)
            }
        })
        weatherRepo.getWeatherFromLatLng(lat, lng)
    }
}