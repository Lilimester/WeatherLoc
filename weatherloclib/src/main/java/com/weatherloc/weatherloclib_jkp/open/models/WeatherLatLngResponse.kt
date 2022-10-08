package com.weatherloc.weatherloclib_jkp.open.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherLatLngResponse {
    @SerializedName("coord")
    @Expose
    private val coord: Coord? = null

    @SerializedName("weather")
    @Expose
    private val weather: List<Weather>? = null

    @SerializedName("base")
    @Expose
    private val base: String? = null

    @SerializedName("main")
    @Expose
    private val main: Main? = null

    @SerializedName("visibility")
    @Expose
    private val visibility: Int? = null

    @SerializedName("wind")
    @Expose
    private val wind: Wind? = null

    @SerializedName("clouds")
    @Expose
    private val clouds: Clouds? = null

    @SerializedName("dt")
    @Expose
    private val dt: Int? = null

    @SerializedName("sys")
    @Expose
    private val system: System? = null

    @SerializedName("timezone")
    @Expose
    private val timezone: Int? = null

    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("name")
    @Expose
    private val name: String? = null

    @SerializedName("cod")
    @Expose
    private val cod: Int? = null
}