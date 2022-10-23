package com.weatherloc.weatherloclib_jkp.open.utils

import kotlinx.coroutines.*

/**
 *
 * Below method uses coroutine scope which creates a [CoroutineScope].
 *
 * Method call for any api call block and throws the exception if found any.
 * failure block would be invoked for the catchBlock.
 *
 * On successful operation, the apiCallBlock would be involved.
 * */
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