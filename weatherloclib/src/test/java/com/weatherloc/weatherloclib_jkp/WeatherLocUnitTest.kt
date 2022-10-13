package com.weatherloc.weatherloclib_jkp

import com.google.gson.Gson
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.networking.WebApiClient
import com.weatherloc.weatherloclib_jkp.open.utils.Constants
import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WeatherLocUnitTest {
    @Test
    fun addition_isCorrect() {
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
        System.out.println("RESPONSE=== ${Gson().toJson(response).toString()}")
        assert(response!=null)
    }

//    @Test
//    fun test_repo_fun_for_weather_current_api(){
//        val repo = WeatherLocRepo()
//
//    }
}