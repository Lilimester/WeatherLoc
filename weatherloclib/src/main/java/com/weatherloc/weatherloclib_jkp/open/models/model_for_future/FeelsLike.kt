package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeelsLike(
    @SerializedName("day")
    @Expose
    val day: Double? = null,

    @SerializedName("night")
    @Expose
    val night: Double? = null,

    @SerializedName("eve")
    @Expose
    val eve: Double? = null,

    @SerializedName("morn")
    @Expose
    val morn: Double? = null,
): Parcelable