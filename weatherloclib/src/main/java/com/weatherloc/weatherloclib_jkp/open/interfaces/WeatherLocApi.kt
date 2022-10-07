package com.weatherloc.weatherloclib_jkp.open.interfaces

import com.weatherloc.weatherloclib_jkp.open.models.WeatherLatLngResponse
import com.weatherloc.weatherloclib_jkp.open.utils.Api
import com.weatherloc.weatherloclib_jkp.open.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherLocApi {
    @GET(Api.currentfetchUsingLatLng)
    suspend fun getWeatherConditionByLatLng (
        @Query(Constants.LATITUDE) lat:Double,
        @Query(Constants.LONGITUDE) lng:Double,
        @Query(Constants.API_QUERY_KEY) api_key:String = Constants.API_KEY
    ) : WeatherLatLngResponse
}