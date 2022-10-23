package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class FutureWeatherData(
    @SerializedName("city")
    @Expose
    var city: City? = null,
    @SerializedName("cod")
    @Expose
    var cod: String? = null,
    @SerializedName("message")
    @Expose
    var message: Double? = null,
    @SerializedName("cnt")
    @Expose
    var cnt: Integer? = null,
    @SerializedName("list")
    @Expose
    var list: MutableList<IndividualDayData>? = null
) : Parcelable