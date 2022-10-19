package com.weatherloc.weatherloclib_jkp.open.models.model_for_current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.weatherloc.weatherloclib_jkp.open.utils.getTemperatureInC
import com.weatherloc.weatherloclib_jkp.open.utils.getTemperatureInF

data class Main(
    @SerializedName("temp")
    @Expose
    private val temp: Double? = null,

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

    val temperatureInCelcius: Double? = temp.getTemperatureInC(),

    val temperatureInFahrenheit: Double? = temp.getTemperatureInF()
)