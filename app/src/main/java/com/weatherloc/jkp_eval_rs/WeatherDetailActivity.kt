package com.weatherloc.jkp_eval_rs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weatherloc.weatherloclib_jkp.WeatherLoc
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import kotlinx.android.synthetic.main.activity_weather_detail.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class WeatherDetailActivity : AppCompatActivity() {

    private lateinit var mCurrentWeatherData: CurrentWeatherData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)

        readIntentParams()
        setUI()
    }

    private fun readIntentParams() {
        mCurrentWeatherData =  intent.getParcelableExtra(Constants.INTENT_DATA) ?: CurrentWeatherData()
    }

    private fun setUI() {
        val weather = mCurrentWeatherData.weather?.get(0)
        mImgDetailWeather.setBackgroundResource(when {
            weather?.main_weather?.contains(Constants.RAIN) ?: false -> R.drawable.weather_rain
            weather?.main_weather?.contains(Constants.CLOUD) ?: false ->R.drawable.weather_cloud
            else -> R.drawable.weather_sun
        })

        mTvDetailTitle.text = weather?.main_weather
        mTvDetailDescription.text = weather?.description

        val dateformatter = SimpleDateFormat(Constants.DATE_FORMAT, Locale.ENGLISH)
        val date = dateformatter.format(Date((mCurrentWeatherData.dt ?: 0)*1000L))
        mTvDetailDate.text = date

        mTvDetailLatitude.text = mCurrentWeatherData.coord?.lat.toString()
        mTvDetailLongitude.text = mCurrentWeatherData.coord?.lon.toString()
        mTvDetailCity.text = mCurrentWeatherData.name
        mTvDetailCountry.text = Locale("", mCurrentWeatherData.system?.country?:getString(R.string.n_a)).displayCountry

        val sunriseFormatter = SimpleDateFormat(Constants.TIME_FORMAT, Locale.ENGLISH)
        val sunriseTime = sunriseFormatter.format(Date((mCurrentWeatherData.system?.sunrise ?: 0)*1000L))
        mTvDetailSunRise.text = sunriseTime

        val sunsetFormatter = SimpleDateFormat(Constants.TIME_FORMAT, Locale.ENGLISH)
        val sunsetTime = sunsetFormatter.format(Date((mCurrentWeatherData.system?.sunset ?: 0)*1000L))
        mTvDetailSunRise.text = sunsetTime

        val tempDecimal = DecimalFormat("##.##").format(WeatherLoc.convertKelvinToCelsius(mCurrentWeatherData.main?.temp))
        mTvDetailTemp.text = getString(R.string.celsius_value,tempDecimal.toString())

        val feelsLikeDecimal = DecimalFormat("##.##").format(WeatherLoc.convertKelvinToCelsius(mCurrentWeatherData.main?.feelsLike))
        mTvDetailFeelsLike.text = getString(R.string.celsius_value,feelsLikeDecimal.toString())

        val tempminDecimal = DecimalFormat("##.##").format(WeatherLoc.convertKelvinToCelsius(mCurrentWeatherData.main?.tempMin))
        mTvDetailTempMin.text = getString(R.string.celsius_value,tempminDecimal.toString())

        val tempmaxDecimal = DecimalFormat("##.##").format(WeatherLoc.convertKelvinToCelsius(mCurrentWeatherData.main?.tempMax))
        mTvDetailTempMax.text = getString(R.string.celsius_value,tempmaxDecimal.toString())

        mTvDetailHumidity.text = getString(R.string.percent_value,mCurrentWeatherData.main?.humidity?.toString(), "%")
        mTvDetailPressureSeaLvl.text = getString(R.string.pressure_value,mCurrentWeatherData.main?.seaLevel?.toString())
        mTvDetailPressureGndLvl.text = getString(R.string.pressure_value,mCurrentWeatherData.main?.grndLevel?.toString())

        val windDecimal = DecimalFormat("##.##").format(WeatherLoc.convertMeterPerSecondToMilePerHour(mCurrentWeatherData.wind?.speed))
        mTvDetailWindSpeed.text = getString(R.string.meters_per_second_value,windDecimal.toString())
        mTvDetailCloudiness.text = getString(R.string.percent_value,mCurrentWeatherData.clouds?.all?.toString(), "%")
        mTvDetailVisibility.text = getString(R.string.meters_value,mCurrentWeatherData.visibility?.toString())
    }

    companion object{
        fun launchActivity(context: Context, data: CurrentWeatherData): Intent =
            Intent(context, WeatherDetailActivity::class.java).apply {
                putExtra(Constants.INTENT_DATA, data)
            }
    }

}