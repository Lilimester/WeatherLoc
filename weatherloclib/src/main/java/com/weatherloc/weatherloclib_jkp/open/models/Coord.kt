package com.weatherloc.weatherloclib_jkp.open.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lon")
    @Expose
    private var lon : Double = 0.0,

    @SerializedName("lat")
    @Expose
    private var lat : Double = 0.0,
)
