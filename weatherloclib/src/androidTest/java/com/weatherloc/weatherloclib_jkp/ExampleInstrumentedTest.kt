package com.weatherloc.weatherloclib_jkp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.testing.TestLifecycleOwner
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class WeatherLocInstrumentalTests {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.weatherloc.weatherloclib_jkp.test", appContext.packageName)
    }

    @Test
    fun test_api_call_from_weather_loc_for_current() {
        val mContext = InstrumentationRegistry.getInstrumentation().targetContext
        val lifecycle = TestLifecycleOwner(
            Lifecycle.State.STARTED, Dispatchers.Main.immediate
        )
        WeatherLoc(mContext).obtainCurrentWeatherByLatLng(lifecycle, 44.10,55.24,{
            assert(it.id!=null)
        },{
            System.out.println("RESPONSE=== ${Gson().toJson(it)}")
            assert(it.message!=null)
        })
    }

    @Test
    fun test_api_call_from_weather_loc_for_future() {
        val mContext = InstrumentationRegistry.getInstrumentation().targetContext
        val lifecycle = TestLifecycleOwner(
            Lifecycle.State.STARTED, Dispatchers.Main.immediate
        )
        WeatherLoc(mContext).obtainFutureWeatherByLatLng(lifecycle, 44.10,55.24, 8,{
            assert(it.cnt !=null)
        },{
            System.out.println("RESPONSE=== ${Gson().toJson(it)}")
            assert(it.message!=null)
        })
    }

    @Test
    fun test_api_call_from_weather_loc_for_5_days() {
        val mContext = InstrumentationRegistry.getInstrumentation().targetContext
        val lifecycle = TestLifecycleOwner(
            Lifecycle.State.STARTED, Dispatchers.Main.immediate
        )
        WeatherLoc(mContext).obtainFiveDaysWeatherByLatLng(lifecycle, 44.10,55.24, {
            assert(it.cnt !=null)
        },{
            System.out.println("RESPONSE=== ${Gson().toJson(it)}")
            assert(it.message!=null)
        })
    }

    @Test
    fun test_internet_connection_condition(){
        val mContext = InstrumentationRegistry.getInstrumentation().targetContext
        val isConnected = WeatherLoc(mContext).isInternetAvailable()
        assert(isConnected)
    }

}