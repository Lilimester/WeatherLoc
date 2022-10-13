package com.weatherloc.weatherloclib_jkp.open.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.*

fun securedCallsOfApi(
    catchBlock: suspend(Exception)-> Unit,
    apiCallBlock: suspend () -> Unit
): Job {
    return CoroutineScope(Dispatchers.IO).launch {
        try{
            apiCallBlock.invoke()
        } catch(e: Exception) {
            catchBlock.invoke(e)
        }
    }
}

fun Double?.getTemperatureInC():Double{
    if(this==null){
        return 0.0
    } else {
        return this - 273.15
    }
}

fun Double?.getTemperatureInF():Double{
    if(this==null){
        return 0.0
    } else {
        return (this - 273.15)*9/5 + 32
    }
}























