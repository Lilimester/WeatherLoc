package com.weatherloc.weatherloclib_jkp.open.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp")
    @Expose
    private val temp: Double? = null,

    @SerializedName("feels_like")
    @Expose
    private val feelsLike: Double? = null,

    @SerializedName("temp_min")
    @Expose
    private val tempMin: Double? = null,

    @SerializedName("temp_max")
    @Expose
    private val tempMax: Double? = null,

    @SerializedName("pressure")
    @Expose
    private val pressure: Int? = null,

    @SerializedName("humidity")
    @Expose
    private val humidity: Int? = null,

    @SerializedName("sea_level")
    @Expose
    private val seaLevel: Int? = null,

    @SerializedName("grnd_level")
    @Expose
    private val grndLevel: Int? = null
)
