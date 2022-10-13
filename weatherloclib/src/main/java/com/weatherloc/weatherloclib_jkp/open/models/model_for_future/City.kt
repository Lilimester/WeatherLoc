package com.weatherloc.weatherloclib_jkp.open.models.model_for_future

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.Coord




class City {
    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("name")
    @Expose
    private val name: String? = null

    @SerializedName("coord")
    @Expose
    private val coord: Coord? = null

    @SerializedName("country")
    @Expose
    private val country: String? = null

    @SerializedName("population")
    @Expose
    private val population: Int? = null

    @SerializedName("timezone")
    @Expose
    private val timezone: Int? = null
}