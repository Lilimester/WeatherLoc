package com.weatherloc.weatherloclib_jkp

import com.weatherloc.weatherloclib_jkp.open.models.WeatherLatLngResponse

open class WeatherLoc {

    fun obtainCurrentWeatherFromLatLng(lat:Double, lng:Double, weather: suspend(WeatherLatLngResponse)-> Unit){
        
    }

    companion object{
        val instance = WeatherLoc()
    }
}