package com.weatherloc.jkp_eval_rs

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.weatherloc.weatherloclib_jkp.WeatherLoc
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.utils.DayRange
import com.weatherloc.weatherloclib_jkp.open.utils.getTemperatureInF

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val weatherloc = WeatherLoc(this)

        val successBlock:(weather: CurrentWeatherData) -> Unit = {
            Log.e("DATA CAME HURRAY", " === === ${it.toString()}")
        }
        val failureBlock:(exception: java.lang.Exception) -> Unit = {
            Log.e("EXCEPTION OH NO!", " === === ${it.message}")
        }

//        weatherloc.obtainCurrentWeatherByLatLng(
//            this,
//            22.77,
//            15.23,
//            successBlock = successBlock,
//            failureBlock = failureBlock
//        )

        weatherloc.obtainFutureWeatherByLatLng(
            this,
            22.77,
            16.88,
            DayRange.FOUR,
            successBlock,
            failureBlock
        )

        10.23.getTemperatureInF()
    }
}