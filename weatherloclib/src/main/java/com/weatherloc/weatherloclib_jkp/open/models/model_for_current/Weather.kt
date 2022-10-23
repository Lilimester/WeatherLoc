package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("main")
    @Expose
    val main_weather: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("icon")
    @Expose
    val icon: String? = null,
): Parcelable