package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rain {

    @SerializedName("1h")
    @Expose
    var oneHour: Int? = null

    @SerializedName("3h")
    @Expose
    var threeHours: Int? = null
}