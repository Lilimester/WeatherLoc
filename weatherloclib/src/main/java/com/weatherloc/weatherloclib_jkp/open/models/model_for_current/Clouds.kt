package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Clouds (
    @SerializedName("all")
    @Expose
    var all: Int? = null
)