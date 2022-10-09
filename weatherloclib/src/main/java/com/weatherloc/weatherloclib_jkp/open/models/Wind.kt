package com.weatherloc.weatherloclib_jkp.open.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wind (
    @SerializedName("speed")
    @Expose
    private val speed: Double? = null,

    @SerializedName("deg")
    @Expose
    private val deg: Int? = null,

    @SerializedName("gust")
    @Expose
    private val gust: Double? = null,
)