package com.weatherloc.weatherloclib_jkp.open.utils

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