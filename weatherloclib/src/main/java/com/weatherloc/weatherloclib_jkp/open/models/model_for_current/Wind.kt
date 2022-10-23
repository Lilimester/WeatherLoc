package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wind (
    @SerializedName("speed")
    @Expose
    val speed: Double? = null,

    @SerializedName("deg")
    @Expose
    val deg: Int? = null,

    @SerializedName("gust")
    @Expose
    val gust: Double? = null,
): Parcelable