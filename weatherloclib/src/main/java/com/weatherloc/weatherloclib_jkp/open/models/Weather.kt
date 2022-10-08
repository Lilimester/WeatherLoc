package com.weatherloc.weatherloclib_jkp.open.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Weather(
    @SerializedName("id")
    @Expose
    private val id: Int? = null,

    @SerializedName("main")
    @Expose
    private val main: String? = null,

    @SerializedName("description")
    @Expose
    private val description: String? = null,

    @SerializedName("icon")
    @Expose
    private val icon: String? = null,
)
