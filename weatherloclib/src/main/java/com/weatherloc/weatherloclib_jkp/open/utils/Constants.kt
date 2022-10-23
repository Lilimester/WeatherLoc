package com.weatherloc.weatherloclib_jkp.open.utils

object Constants {
    const val BASE_URL = "https://api.openweathermap.org/"
    const val LATITUDE = "lat"
    const val LONGITUDE = "lon"
    const val COUNT = "cnt"
    const val API_QUERY_KEY = "appid"
    const val UNITS = "units"
    const val API_KEY = "ae1c4977a943a50eaa7da25e6258d8b2"
    const val CONNECTION_TIMEOUT = 20L
}

object Api {
    const val currentfetchUsingLatLng = "data/2.5/weather?"
    const val fetchUsingLatLngForSpecificDuration = "data/2.5/forecast/daily?"
    const val fetchUsingLatLngForFiveDays = "data/2.5/forecast?"
    const val appendApi = "&appid=${Constants.API_KEY}}"
}