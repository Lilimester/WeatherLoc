package com.weatherloc.weatherloclib_jkp.open.networking

import com.weatherloc.weatherloclib_jkp.open.interfaces.WeatherLocApi
import com.weatherloc.weatherloclib_jkp.open.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebApiClient {

    private var mRetrofit : Retrofit? = null
    private val mIntercepter = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun clientCreation(): WeatherLocApi {
        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(mIntercepter)
            .build()

        return when(mRetrofit != null){
            true-> mRetrofit?.create(WeatherLocApi::class.java)!!
            false->{
                mRetrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                mRetrofit?.create(WeatherLocApi::class.java)!!
            }
        }
    }

    companion object{
        val initiateWeatherLocApi : WeatherLocApi by lazy {
            WebApiClient().clientCreation()
        }
    }

}