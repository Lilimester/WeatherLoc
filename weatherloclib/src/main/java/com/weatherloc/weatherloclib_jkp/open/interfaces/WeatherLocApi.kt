package com.weatherloc.weatherloclib_jkp.open.interfaces

import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import com.weatherloc.weatherloclib_jkp.open.utils.Api
import com.weatherloc.weatherloclib_jkp.open.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherLocApi {
    @GET(Api.currentfetchUsingLatLng)
    suspend fun getWeatherConditionByLatLng (
        @Query(Constants.LATITUDE) lat:Double,
        @Query(Constants.LONGITUDE) lng:Double,
        @Query(Constants.UNITS) unit:TemperatureUnitType? = null,
        @Query(Constants.API_QUERY_KEY) api_key:String = Constants.API_KEY,
    ) : CurrentWeatherData

    @GET(Api.fetchUsingLatLngForSpecificDuration)
    suspend fun getWeatherConditionByLatLngForFuture (
        @Query(Constants.LATITUDE) lat:Double,
        @Query(Constants.LONGITUDE) lng:Double,
        @Query(Constants.COUNT) cnt:Int,
        @Query(Constants.UNITS) unit:TemperatureUnitType? = null,
        @Query(Constants.API_QUERY_KEY) api_key:String = Constants.API_KEY
    ) : FutureWeatherData
}