package com.weatherloc.weatherloclib_jkp.open.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Clouds (
    @SerializedName("all")
    @Expose
    private var all: Int? = null
)