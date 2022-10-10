package com.weatherloc.jkp_eval_rs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val weatherloc = WeatherLoc.instance
//        weatherloc.obtainCurrentWeatherByLatLng(this, 22.77, 15.23, object: WeatherForCurrentWithLatLng{
//            override fun currentWeatherCondition(weather: WeatherLatLngResponse?) {
//                Log.e("DATA CAME HURRAY", " === === ${weather?.weather.toString()}")
//            }
//        })

//        val weatherloc = WeatherLoc.instance
//        weatherloc.obtainCurrentWeatherByLatLng(this, 22.77, 15.23, {
//            Log.e("DATA CAME HURRAY", " === === ${it?.weather.toString()}")
//        },{})
    }
}