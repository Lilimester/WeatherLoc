package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Temp {
    @SerializedName("day")
    @Expose
    private val day: Double? = null

    @SerializedName("min")
    @Expose
    private val min: Double? = null

    @SerializedName("max")
    @Expose
    private val max: Double? = null

    @SerializedName("night")
    @Expose
    private val night: Double? = null

    @SerializedName("eve")
    @Expose
    private val eve: Double? = null

    @SerializedName("morn")
    @Expose
    private val morn: Double? = null
}