package com.weatherloc.jkp_eval_rs

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.weatherloc.weatherloclib_jkp.WeatherLoc
import com.weatherloc.weatherloclib_jkp.open.models.WeatherData

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val weatherloc = WeatherLoc.instance

        val successBlock:(weather: WeatherData) -> Unit = {
            Log.e("DATA CAME HURRAY", " === === ${it.toString()}")
        }
        val failureBlock:(exception: java.lang.Exception) -> Unit = {
            Log.e("EXCEPTION OH NO!", " === === ${it.message}")
        }

        weatherloc.obtainCurrentWeatherByLatLng(
            this,
            22.77,
            15.23,
            successBlock = successBlock,
            failureBlock = failureBlock
        )
    }
}