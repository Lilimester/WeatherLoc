package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CurrentWeatherData {
    @SerializedName("coord")
    @Expose
    val coord: Coord? = null

    @SerializedName("weather")
    @Expose
    val weather: List<Weather>? = null

    @SerializedName("base")
    @Expose
    val base: String? = null

    @SerializedName("main")
    @Expose
    val main: Main? = null

    @SerializedName("visibility")
    @Expose
    val visibility: Int? = null

    @SerializedName("wind")
    @Expose
    val wind: Wind? = null

    @SerializedName("clouds")
    @Expose
    val clouds: Clouds? = null

    @SerializedName("dt")
    @Expose
    val dt: Int? = null

    @SerializedName("sys")
    @Expose
    val system: System? = null

    @SerializedName("rain")
    @Expose
    val rain: Rain? = null

    @SerializedName("snow")
    @Expose
    val snow: Snow? = null

    @SerializedName("timezone")
    @Expose
    val timezone: Int? = null

    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("cod")
    @Expose
    val cod: Int? = null
}