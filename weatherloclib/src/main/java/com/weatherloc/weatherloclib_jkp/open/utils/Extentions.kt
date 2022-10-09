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

@RequiresApi(Build.VERSION_CODES.M)
fun isInternetAvailable(context: Context):Boolean{
    val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectionManager.activeNetworkInfo
    return networkInfo!=null && networkInfo.isAvailable && networkInfo.isConnected
}






















