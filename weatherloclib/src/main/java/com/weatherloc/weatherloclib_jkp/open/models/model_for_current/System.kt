package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class System(
    @SerializedName("type")
    @Expose
    var type:Int = 0,

    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @SerializedName("country")
    @Expose
    var country: String = "",

    @SerializedName("sunrise")
    @Expose
    var sunrise: Int = 0,

    @SerializedName("sunset")
    @Expose
    var sunset: Int = 0,
): Parcelable
