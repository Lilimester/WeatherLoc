package com.weatherloc.jkp_eval_rs.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weatherloc.jkp_eval_rs.Utils.Constants
import com.weatherloc.jkp_eval_rs.R
import com.weatherloc.jkp_eval_rs.adapter.WeatherListingAdapter
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import kotlinx.android.synthetic.main.activity_weather_listing.*
import java.util.*

class WeatherListingActivity : AppCompatActivity() {

    private var mIsFor5DaysWeather: Boolean = false
    private var mLatitude: Double = 0.0
    private var mLongitude: Double = 0.0
    private var mNumberOfDays: Int = 0
    private lateinit var mWeatherData: FutureWeatherData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_listing)
        readIntentData()
        setUI()
    }

    private fun setUI() {
        mRvWeatherListing.setHasFixedSize(false)
        mRvWeatherListing.layoutManager = LinearLayoutManager(this)
        mRvWeatherListing.adapter = WeatherListingAdapter()
        mRvWeatherListing.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        (mRvWeatherListing.adapter as WeatherListingAdapter).setData(mWeatherData.list ?: mutableListOf())

        mTvCity.text = mWeatherData.city?.name?:getString(R.string.n_a)
        mTvLatitude.text = mWeatherData.city?.coord?.lat.toString()
        mTvLongitude.text = mWeatherData.city?.coord?.lon.toString()
        mTvCountry.text = Locale("", mWeatherData.city?.country?:getString(R.string.n_a)).displayCountry
        mTvPopulation.text = mWeatherData.city?.population.toString()
    }

    private fun readIntentData() {
        mWeatherData = intent.getParcelableExtra(Constants.INTENT_DATA) ?: FutureWeatherData()
    }

    companion object{
        fun launchActivity(context: Context, data:FutureWeatherData): Intent =
            Intent(context, WeatherListingActivity::class.java).apply {
                putExtra(Constants.INTENT_DATA, data)
            }
    }
}