package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rain(

    @SerializedName("1h")
    @Expose
    var oneHour: Double? = null,

    @SerializedName("3h")
    @Expose
    var threeHours: Double? = null,
): Parcelable