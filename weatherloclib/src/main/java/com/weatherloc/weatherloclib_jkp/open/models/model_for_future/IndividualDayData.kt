package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.Weather

class IndividualDayData {
    @SerializedName("dt")
    @Expose
    private val dt: Int? = null

    @SerializedName("sunrise")
    @Expose
    private val sunrise: Int? = null

    @SerializedName("sunset")
    @Expose
    private val sunset: Int? = null

    @SerializedName("temp")
    @Expose
    private val temp: Temp? = null

    @SerializedName("feels_like")
    @Expose
    private val feelsLike: FeelsLike? = null

    @SerializedName("pressure")
    @Expose
    private val pressure: Int? = null

    @SerializedName("humidity")
    @Expose
    private val humidity: Int? = null

    @SerializedName("weather")
    @Expose
    private val weather: List<Weather>? = null

    @SerializedName("speed")
    @Expose
    private val speed: Double? = null

    @SerializedName("deg")
    @Expose
    private val deg: Int? = null

    @SerializedName("gust")
    @Expose
    private val gust: Double? = null

    @SerializedName("clouds")
    @Expose
    private val clouds: Int? = null

    @SerializedName("pop")
    @Expose
    private val pop: Double? = null

    @SerializedName("rain")
    @Expose
    private val rain: Double? = null
}