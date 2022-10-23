package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.Clouds
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.Rain
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.Weather
import kotlinx.parcelize.Parcelize

@Parcelize
data class IndividualDayData (
    @SerializedName("dt")
    @Expose
    val dt: Int? = null,

    @SerializedName("sunrise")
    @Expose
    val sunrise: Int? = null,

    @SerializedName("sunset")
    @Expose
    val sunset: Int? = null,

    @SerializedName("temp")
    @Expose
    val temp: Temperature? = null,

    @SerializedName("feels_like")
    @Expose
    val feelsLike: FeelsLike? = null,

    @SerializedName("pressure")
    @Expose
    val pressure: Int? = null,

    @SerializedName("humidity")
    @Expose
    val humidity: Int? = null,

    @SerializedName("weather")
    @Expose
    val weather: List<Weather>? = null,

    @SerializedName("speed")
    @Expose
    val speed: Double? = null,

    @SerializedName("deg")
    @Expose
    val deg: Int? = null,

    @SerializedName("gust")
    @Expose
    val gust: Double? = null,

    @SerializedName("clouds")
    @Expose
    val clouds: Clouds? = null,

    @SerializedName("pop")
    @Expose
    val pop: Double? = null,

    @SerializedName("rain")
    @Expose
    val rain: Rain? = null,
): Parcelable