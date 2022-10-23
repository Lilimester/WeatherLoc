package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.Coord
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class City (
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("coord")
    @Expose
    val coord: Coord? = null,

    @SerializedName("country")
    @Expose
    val country: String? = null,

    @SerializedName("population")
    @Expose
    val population: Int? = null,

    @SerializedName("timezone")
    @Expose
    val timezone: Int? = null,
): Parcelable