package com.weatherloc.weatherloclib_jkp.open.interfaces

import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.FutureWeatherData
import com.weatherloc.weatherloclib_jkp.open.utils.Api
import com.weatherloc.weatherloclib_jkp.open.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherLocApi {

    /**
     * A get request which would provide the current weather data based on the latitude and longitude.
     * It requires four parameters.
     *
     * 1: lat : Latitude of the location.
     * 2: lng : Longitude of the location.
     * 3: unit : [TemperatureUnitType] which would define the unit type values in which you would
     *           like to have values in.
     * 4: api_key : By default this value is added to the call, so no need to provide it externally.
     * */
    @GET(Api.currentfetchUsingLatLng)
    suspend fun getWeatherConditionByLatLng (
        @Query(Constants.LATITUDE) lat:Double,
        @Query(Constants.LONGITUDE) lng:Double,
        @Query(Constants.UNITS) unit:TemperatureUnitType? = null,
        @Query(Constants.API_QUERY_KEY) api_key:String = Constants.API_KEY,
    ) : CurrentWeatherData

    /**
     * A get request which would provide the future weather data of mentioned counts based on the
     * latitude and longitude.
     *
     * It requires five parameters.
     *
     * 1: lat : Latitude of the location.
     * 2: lng : Longitude of the location.
     * 3: cnt : Count of the days in future you would like to know the weather from current day.
     * 4: unit : [TemperatureUnitType] which would define the unit type values in which you would
     *           like to have values in.
     * 5: api_key : By default this value is added to the call, so no need to provide it externally.
     * */
    @GET(Api.fetchUsingLatLngForSpecificDuration)
    suspend fun getWeatherConditionByLatLngForFuture (
        @Query(Constants.LATITUDE) lat:Double,
        @Query(Constants.LONGITUDE) lng:Double,
        @Query(Constants.COUNT) cnt:Int,
        @Query(Constants.UNITS) unit:TemperatureUnitType? = null,
        @Query(Constants.API_QUERY_KEY) api_key:String = Constants.API_KEY
    ) : FutureWeatherData

    /**
     * A get request which would provide the 5 days weather data from today, based on the
     * latitude and longitude.
     *
     * It requires four parameters.
     *
     * 1: lat : Latitude of the location.
     * 2: lng : Longitude of the location.
     * 3: unit : [TemperatureUnitType] which would define the unit type values in which you would
     *           like to have values in.
     * 4: api_key : By default this value is added to the call, so no need to provide it externally.
     * */

    @GET(Api.fetchUsingLatLngForFiveDays)
    suspend fun getWeatherConditionByLatLngForFiveFutureDays (
        @Query(Constants.LATITUDE) lat:Double,
        @Query(Constants.LONGITUDE) lng:Double,
        @Query(Constants.UNITS) unit:TemperatureUnitType? = null,
        @Query(Constants.API_QUERY_KEY) api_key:String = Constants.API_KEY
    ) : FutureWeatherData
}