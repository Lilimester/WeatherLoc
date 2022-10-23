package com.weatherloc.weatherloclib_jkp.open.networking

import com.weatherloc.weatherloclib_jkp.open.interfaces.WeatherLocApi
import com.weatherloc.weatherloclib_jkp.open.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class manages the web apis which places the network calls.
 * */
internal class WebApiClient {

    /**
     * Below intance is a type of Retrofit which adapts a Java interface
     * to HTTP calls by using annotations on the declared methods to define
     * how requests are made.
     * */
    private lateinit var mRetrofit : Retrofit

    /**
     * An OkHttp interceptor which logs request and response information.
     * */
    private val mIntercepter = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.NONE
    }

    /**
     * Below method creates the weatherLocApi client, a gateway through which
     * the network call methods would be accessed.
     * */
    private fun clientCreation(): WeatherLocApi {
        mRetrofit = getRetrofitInstance()
        return mRetrofit.create(WeatherLocApi::class.java)!!
    }

    /**
     * Below method provides the instance of the retro fit. It also adds the
     * interceptor i.e. OkHttp which intercepts the request and response.
     * */
    private fun getRetrofitInstance():Retrofit{
        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(mIntercepter)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object{
        /**
         * Below value is accessible and would be created lazy hence try not to
         * add it in the synchronized method due to the property of lazy. It helps
         * optimized use of resources.
         * */
        val initiateWeatherLocApi : WeatherLocApi by lazy {
            WebApiClient().clientCreation()
        }

        /**
         * Below value provides the Retrofit instance, as of now it is being used for testing.
         * It can be utized for the client creation.
         * */
        val client = WebApiClient().getRetrofitInstance()
    }

}