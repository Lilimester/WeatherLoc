package com.weatherloc.weatherloclib_jkp

import com.google.gson.Gson
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient
import com.weatherloc.weatherloclib_jkp.open.utils.Constants
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WeatherLocUnitTest {

    private val zeroDouble = 0.0
    private val thirtyTwoFahrenheit = 32.0
    private val kelvinBaseValue = 273.15

    @Test
    fun checkWebClientAndUrl() {
        val retroFitInstance = WebApiClient.client
        assertTrue(retroFitInstance.baseUrl().toUrl().toString() == Constants.BASE_URL)
    }

    @Test
    fun test_api_for_weather_current_lat_lng() {
        val api = WebApiClient.initiateWeatherLocApi
        var response : CurrentWeatherData?
        runBlocking {
            response = api.getWeatherConditionByLatLng(44.34, 10.99)
        }
        System.out.println("RESPONSE=== ${Gson().toJson(response)}")
        assert(response!=null)
    }

    @Test
    fun test_api_for_weather_future_lat_lng() {
        val api = WebApiClient.initiateWeatherLocApi
        var response : FutureWeatherData?
        runBlocking {
            response = api.getWeatherConditionByLatLngForFuture(44.34, 10.99, 8)
        }
        System.out.println("RESPONSE=== ${Gson().toJson(response)}")
        assert(response!=null)
    }

    @Test
    fun test_api_for_weather_5_days_lat_lng() {
        val api = WebApiClient.initiateWeatherLocApi
        var response : FutureWeatherData
        runBlocking {
            response = api.getWeatherConditionByLatLngForFiveFutureDays(44.34, 10.99)
        }
        System.out.println("RESPONSE=== ${Gson().toJson(response)}")
        assert(response!=null)
    }

    //Value test...
    @Test
    fun test_logic_convert_kelvin_to_celsius(){
        val temperature = 273.15
        assert(WeatherLoc.convertKelvinToCelsius(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_kelvin_to_fahrenheit(){
        val temperature = kelvinBaseValue
        System.out.println("VALUE === ${WeatherLoc.convertKelvinToFahrenheit(temperature)}")
        assert(WeatherLoc.convertKelvinToFahrenheit(temperature)==thirtyTwoFahrenheit)
    }

    @Test
    fun test_logic_convert_celsius_to_kelvin(){
        val temperature = -273.15
        assert(WeatherLoc.convertCelsiusToKelvin(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_celsius_to_fahrenheit(){
        val temperature = 0.0
        assert(WeatherLoc.convertCelsiusToFahrenheit(temperature)==thirtyTwoFahrenheit)
    }

    @Test
    fun test_logic_convert_fahrenheit_to_kelvin(){
        val temperature = 32.0
        assert(WeatherLoc.convertFahrenheitToKelvin(temperature)==kelvinBaseValue)
    }

    @Test
    fun test_logic_convert_fahrenheit_to_celsius(){
        val temperature = 32.0
        assert(WeatherLoc.convertFahrenheitToCelsius(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_mile_per_hour_to_meter_per_second(){
        val speed = 0.0
        assert(WeatherLoc.convertMilePerHourToMeterPerSecond(speed)==zeroDouble)
    }

    @Test
    fun test_logic_convert_meter_per_second_to_mile_per_hour(){
        val speed = 0.0
        assert(WeatherLoc.convertMeterPerSecondToMilePerHour(speed)==zeroDouble)
    }

    //Null tests...
    @Test
    fun test_logic_convert_kelvin_to_celsius_null_check(){
        val temperature = null
        assert(WeatherLoc.convertKelvinToCelsius(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_kelvin_to_fahrenheit_null_check(){
        val temperature = null
        assert(WeatherLoc.convertKelvinToFahrenheit(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_celsius_to_kelvin_null_check(){
        val temperature = null
        assert(WeatherLoc.convertCelsiusToKelvin(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_celsius_to_fahrenheit_null_check(){
        val temperature = null
        assert(WeatherLoc.convertCelsiusToFahrenheit(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_fahrenheit_to_kelvin_null_check(){
        val temperature = null
        assert(WeatherLoc.convertFahrenheitToKelvin(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_fahrenheit_to_celsius_null_check(){
        val temperature = null
        assert(WeatherLoc.convertFahrenheitToCelsius(temperature)==zeroDouble)
    }

    @Test
    fun test_logic_convert_mile_per_hour_to_meter_per_second_null_check(){
        val speed = null
        assert(WeatherLoc.convertMilePerHourToMeterPerSecond(speed)==zeroDouble)
    }

    @Test
    fun test_logic_convert_meter_per_second_to_mile_per_hour_null_check(){
        val speed = null
        assert(WeatherLoc.convertMeterPerSecondToMilePerHour(speed)==zeroDouble)
    }
}