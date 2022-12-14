package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main(
    @SerializedName("temp")
    @Expose
    val temp: Double? = null,

    @SerializedName("feels_like")
    @Expose
    val feelsLike: Double? = null,

    @SerializedName("temp_min")
    @Expose
    val tempMin: Double? = null,

    @SerializedName("temp_max")
    @Expose
    val tempMax: Double? = null,

    @SerializedName("pressure")
    @Expose
    val pressure: Int? = null,

    @SerializedName("humidity")
    @Expose
    val humidity: Int? = null,

    @SerializedName("sea_level")
    @Expose
    val seaLevel: Int? = null,

    @SerializedName("grnd_level")
    @Expose
    val grndLevel: Int? = null,
): Parcelable
