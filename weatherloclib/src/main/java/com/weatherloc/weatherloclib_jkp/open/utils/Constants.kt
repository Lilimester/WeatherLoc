package com.weatherloc.weatherloclib_jkp.open.utils

object Constants {
    const val BASE_URL = "https://api.openweathermap.org/"
    const val LATITUDE = "lat"
    const val LONGITUDE = "lon"
    const val API_KEY = "ae1c4977a943a50eaa7da25e6258d8b2"
    const val CONNECTION_TIMEOUT = 20L
}

object Api {
    private const val fetchUsingLatLng = "data/2.5/weather?lat={${Constants.LATITUDE}}&lon={${Constants.LONGITUDE}}"
    private const val appendApi = "&appid=${Constants.API_KEY}}"

    const val apiWeatherUsingLatLng = "$fetchUsingLatLng$appendApi"
}