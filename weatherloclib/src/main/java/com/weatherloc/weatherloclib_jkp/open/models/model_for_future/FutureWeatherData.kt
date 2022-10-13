package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FutureWeatherData {

    @SerializedName("city")
    @Expose
    private var city: City? = null
    @SerializedName("cod")
    @Expose
    private var cod:String? = null
    @SerializedName("message")
    @Expose
    private var message: Double? = null
    @SerializedName("cnt")
    @Expose
    private var cnt: Integer? = null
    @SerializedName("list")
    @Expose
    private var list: MutableList<IndividualDayData>? = null
}