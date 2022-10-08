package com.weatherloc.weatherloclib_jkp.open.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class System(
    @SerializedName("type")
    @Expose
    private var type:Int = 0,

    @SerializedName("id")
    @Expose
    private var id: Int = 0,

    @SerializedName("country")
    @Expose
    private var country: String = "",

    @SerializedName("sunrise")
    @Expose
    private var sunrise: Int = 0,

    @SerializedName("sunset")
    @Expose
    private var sunset: Int = 0,
)
