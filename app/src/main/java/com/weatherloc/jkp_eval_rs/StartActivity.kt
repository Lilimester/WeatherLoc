package com.weatherloc.jkp_eval_rs

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.weatherloc.weatherloclib_jkp.WeatherLoc
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.activity_weather_listing.*

class StartActivity : AppCompatActivity() {

    private val successFutureWeatherBlock = { weather: FutureWeatherData ->
        mPbLoader.visibility = View.GONE
        mLlRootLayout.visibility = View.VISIBLE
        startActivity(WeatherListingActivity.launchActivity(this, weather))
    }

    private val successCurrentWeatherBlock = {weather: CurrentWeatherData ->
        mPbLoader.visibility = View.GONE
        mLlRootLayout.visibility = View.VISIBLE
        startActivity(WeatherDetailActivity.launchActivity(this, weather))
    }

    private val failureBlock = { exception: Exception ->
        val data = exception.message.toString()
        mPbLoader.visibility = View.GONE
        mLlRootLayout.visibility = View.VISIBLE
        print(data)
        InfoDialog.show(this, "Alert","Something went wrong \n\n$data")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        setClickListeners()
    }

    private fun setClickListeners() {
        mBtnFetchWeatherDetails.setOnClickListener {
            fetchWeatherDetails()
        }
        mRgOptions.setOnCheckedChangeListener { radioGroup, id ->
            mLlFutureDayCountView.visibility = if(mRbFuture.isChecked) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun fetchWeatherDetails() {
        when{
            mRb5Days.isChecked -> listOutWeatherInfo(true)
            mRbCurrent.isChecked -> fetchCurrentWeather()
            mRbFuture.isChecked -> listOutWeatherInfo(false)
        }
    }

    private fun listOutWeatherInfo(isFor5Days: Boolean) {
        val weatherLoc = WeatherLoc(this)
        mPbLoader.visibility = View.VISIBLE
        mLlRootLayout.visibility = View.GONE
        if(isFor5Days) {
            weatherLoc.obtainFiveDaysWeatherByLatLng(
                this,
                mEdtLatitude.text.toString().toDouble(),
                mEdtLongitude.text.toString().toDouble(),
                successFutureWeatherBlock,
                failureBlock
            )
        } else {
            InfoDialog.show(this, getString(R.string.coming_soon),getString(R.string.feature_coming_soon_future))
            mLlRootLayout.visibility = View.VISIBLE
            //Todo uncomment below code when api key is available which supports future weather findings...
//            weatherLoc.obtainFutureWeatherByLatLng(
//                this,
//                mEdtLatitude.text.toString().toDouble(),
//                mEdtLongitude.text.toString().toDouble(),
//                mEdtDaysCount.text.toString().toInt(),
//                successFutureWeatherBlock,
//                failureBlock
//            )
        }
    }

    private fun fetchCurrentWeather() {
        mPbLoader.visibility = View.VISIBLE
        mLlRootLayout.visibility = View.GONE
        WeatherLoc(this).obtainCurrentWeatherByLatLng(
            this,
            mEdtLatitude.text.toString().toDouble(),
            mEdtLongitude.text.toString().toDouble(),
            successCurrentWeatherBlock,
            failureBlock
        )
    }
}