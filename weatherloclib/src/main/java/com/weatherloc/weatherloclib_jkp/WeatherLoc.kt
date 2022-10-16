package com.weatherloc.weatherloclib_jkp

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LifecycleOwner
import com.weatherloc.weatherloclib_jkp.open.OpenWeatherLocCaller
import com.weatherloc.weatherloclib_jkp.open.enum.TemperatureUnitType
import com.weatherloc.weatherloclib_jkp.open.models.model_for_current.CurrentWeatherData
import com.weatherloc.weatherloclib_jkp.open.utils.DayRange

/**
 * This class helps in obtaining the weather information for current as well as for the specified duration
 * of the time. The initialization of the class requires two data among them, one is mandatory and other
 * one is non mandatory.
 *
 * Required parameter:
 *      context of type Context - Interface to global information about an application environment.  This is
 *                       an abstract class whose implementation is provided by the Android system.
 *                       It allows access to application-specific resources and classes, as well as
 *                       up-calls for application-level operations such as launching activities broadcasting
 *                       and receiving intents, etc.
 *
 * Non mandatory optional parameter:
 *      mUnitType of type TemperatureUnitType [Enum] - This parameter accepts the enum stating the unit type
 *      which you would require.
 *          TemperatureUnitType.STANDARD: This unit type division involves the temperature type as kelvin and
 *              for speed, the unit type is meters/second.
 *          TemperatureUnitType.METRIC: This unit type division involves the temperature type as celsius and
 *              for speed, the unit type is meters/second.
 *          TemperatureUnitType.IMPERIAL: This unit type division involves the temperature type as fahrenheit and
 *              for speed, the unit type is meters/second.
 *
 * Instance for WeatherLoc which is being created with above optional unit type param will provide the data
 * of weather in mentioned unit type.
 *
 * Incase of changing the perticular data or field to other data type for usage, please refer to the conversion
 * section which is at bottom of this class. There are companion methods which can be utilized for such purpose.
 *
 */
class WeatherLoc(private val mContext: Context, private val mUnitType:TemperatureUnitType? = null) : OpenWeatherLocCaller() {

   /**
    * below function checks for the connectivity of the internet.
    *
    * Parameters: Context - Interface to global information about an application environment.  This is
    *                       an abstract class whose implementation is provided by the Android system.
    *                       It allows access to application-specific resources and classes, as well as
    *                       up-calls for application-level operations such as launching activities broadcasting
    *                       and receiving intents, etc.
    *
    * Result: true - This value is returned when network connectivity is available.
    *         false - This value is returned when network connectivity is not available.
    */

    @RequiresApi(Build.VERSION_CODES.M)
    fun isInternetAvailable(context: Context):Boolean{
        val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isAvailable && networkInfo.isConnected
    }

   /**
    * Below function fetches the weather data for current time based on the latitude and longitude.
    *
    * The inner implementation is based on the coroutine hence can be called from any view classes
    * without putting burden to the main thread.
    *
    * Parameters:
    *
    * lifecycleOwner - A class that has an Android lifecycle. These events can be used by custom
    * components to handle lifecycle changes without implementing any code inside the Activity or
    * the Fragment.
    *
    * lat - Double datatype value of Latitude.
    *
    * lng - Double datatype value of Longitude.
    *
    * successBlock - A method callback that provides the end result of weather data. weather data
    * object has multiple properties through which data can be obtained.
    *
    * object which is received in callback, it's parameters are as follows.
    *
    *   weather:
    *       coord -
    *           coord.lon - City geo location, longitude
    *           coord.lat - City geo location, latitude
    *       weather -
    *           weather.id - Weather condition id
    *           weather.main_weather - Group of weather parameters (Rain, Snow, Extreme etc.)
    *           weather.description - Weather condition within the group. You can get the output in your language. Learn more
    *           weather.icon Weather icon id
    *       base - Internal parameter
    *       main -
    *           main.temp - Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.feels_like - Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.pressure - Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
    *           main.humidity - Humidity, %
    *           main.temp_min - Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.temp_max - Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *           main.sea_level - Atmospheric pressure on the sea level, hPa
    *           main.grnd_level - Atmospheric pressure on the ground level, hPa
    *       visibility - Visibility, meter. The maximum value of the visibility is 10km
    *       wind -
    *           wind.speed - Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
    *           wind.deg - Wind direction, degrees (meteorological)
    *           wind.gust - Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    *       clouds -
    *           clouds.all - Cloudiness, %
    *       rain -
    *           rain.oneHour - Rain volume for the last 1 hour, mm
    *           rain.threeHours - Rain volume for the last 3 hours, mm
    *       snow -
    *           snow.oneHour - Snow volume for the last 1 hour, mm
    *           snow.threeHours - Snow volume for the last 3 hours, mm
    *       dt - Time of data calculation, unix, UTC
    *       sys -
    *           sys.type - Internal parameter
    *           sys.id - Internal parameter
    *           sys.message - Internal parameter
    *           sys.country - Country code (GB, JP etc.)
    *           sys.sunrise - Sunrise time, unix, UTC
    *           sys.sunset - Sunset time, unix, UTC
    *       timezone - Shift in seconds from UTC
    *       id - City ID. Please note that built-in geocoder functionality has been deprecated. Learn more here.
    *       name - City name. Please note that built-in geocoder functionality has been deprecated. Learn more here.
    *       cod - Internal parameter
    *
    * failureBlock -  A method callback that provides the exception which has occured.
    */
    fun obtainCurrentWeatherByLatLng(
        lifecycleOwner: LifecycleOwner,
        lat: Double,
        lng: Double,
        successBlock: (weather: CurrentWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit
    ) {
        if(isInternetAvailable(mContext)) {
            obtainCurrentWeatherFromLatLng(
                lifecycleOwner,
                lat,
                lng,
                successBlock,
                failureBlock,
                mUnitType
            )
        } else {
            val exception: Exception = Exception("Internet is not available!")
            failureBlock.invoke(exception)
        }
    }

    /**
    * Below function fetches the weather data for current time based on the latitude and longitude.
    *
    * The inner implementation is based on the coroutine hence can be called from any view classes
    * without putting burden to the main thread.
    *
    * Parameters:
    *
    * lifecycleOwner - A class that has an Android lifecycle. These events can be used by custom
    * components to handle lifecycle changes without implementing any code inside the Activity or
    * the Fragment.
    *
    * lat - Double datatype value of Latitude.
    *
    * lng - Double datatype value of Longitude.
    *
    * successBlock - A method callback that provides the end result of weather data. weather data
    * object has multiple properties through which data can be obtained.
    *
    * object which is received in callback for weather, it's parameters are as follows.
    *
    * city:
    *      city.id City ID. Please note that built-in geocoder functionality has been deprecated. Learn more here.
    *      city.name City name. Please note that built-in geocoder functionality has been deprecated. Learn more here.
    * city.coord:
    *      city.coord.lat: City geo location, latitude
    *      city.coord.lon: City geo location, longitude
    * country: Country code (GB, JP etc.). Please note that built-in geocoder functionality has been deprecated. Learn more here.
    * population: Internal parameter
    * timezone: Shift in seconds from UTC
    * cod: Internal parameter
    * message: Internal parameter
    * cnt: A number of days returned in the API response
    * list:
    *      list.dt: Time of data forecasted
    *      list.temp:
    *          list.temp.day: Day temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.temp.min: Min daily temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.temp.max: Max daily temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.temp.night: Night temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.temp.eve: Evening temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.temp.morn: Morning temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *      list.feels_like:
    *          list.feels_like.day: Day temperature.This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.feels_like.night: Night temperature.This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.feels_like.eve: Evening temperature.This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *          list.feels_like.morn: Morning temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    *      list.pressure: Atmospheric pressure on the sea level, hPa
    *      list.humidity: Humidity, %
    *      list.weather: (more info Weather condition codes)
    *          list.weather.id: Weather condition id
    *          list.weather.main: Group of weather parameters (Rain, Snow, Extreme etc.)
    *          list.weather.description: Weather condition within the group. You can get the output in your language. Learn more.
    *          list.weather.icon: Weather icon id
    *      list.speed: Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
    *      list.deg: Wind direction, degrees (meteorological)
    *      list.gust: Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
    *      list.clouds: Cloudiness, %
    *      list.rain: Precipitation volume, mm
    *      list.snow: Snow volume, mm
    *      list.pop: Probability of precipitation. The values of the parameter vary between 0 and 1, where 0 is equal to 0%, 1 is equal to 100%
    */

    fun obtainFutureWeatherByLatLng(
        lifecycleOwner: LifecycleOwner,
        lat: Double,
        lng: Double,
        dayRange: DayRange,
        successBlock: (weather: CurrentWeatherData) -> Unit,
        failureBlock: (exception:Exception) -> Unit
    ) {
        obtainFutureWeatherFromLatLng(lifecycleOwner, lat, lng, dayRange, successBlock, failureBlock, mUnitType)
    }

    companion object{

        /**
        * The method takes up a double value of temparature in kelvin unit and converts the
        * value of temperature from kelvin to celsius.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertKelvinToCelsius(value: Double):Double {
            return value - 273.15
        }

        /**
        * The method takes up a double value of temparature in kelvin unit and converts the
        * value of temperature from kelvin to fahrenheit.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertKelvinToFahrenheit(value: Double):Double{
            return (convertKelvinToCelsius(value)) * 9 / 5 + 32
        }

        /**
        * The method takes up a double value of temparature in celsius unit and converts the
        * value of temperature from celsius to kelvin.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertCelsiusToKelvin(value: Double):Double {
            return value + 273.15
        }

        /**
        * The method takes up a double value of temparature in celsius unit and converts the
        * value of temperature from celsius to fahrenheit.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertCelsiusToFahrenheit(value:Double):Double {
            return value * 9 / 5 + 32
        }

        /**
        * The method takes up a double value of temparature in fahrenheit unit and converts the
        * value of temperature from fahrenheit to kelvin.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertFahrenheitToKelvin(value:Double):Double {
            return convertFahrenheitToCelsius(value) + 273.15
        }

        /**
        * The method takes up a double value of temparature in fahrenheit unit and converts the
        * value of temperature from fahrenheit to celsius.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertFahrenheitToCelsius(value:Double):Double {
            return (value - 32) * 5 / 9
        }

        /**
        * The method takes up a double value of speed in miles/hour unit and converts the
        * value of speed from miles/hour to meter/second.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertMilePerHourToMeterPerSecond(value:Double):Double{
            return value / 2.237
        }

        /**
        * The method takes up a double value of speed in meter/second unit and converts the
        * value of speed from meter/second to miles/hour.
        *
        * This method is extra as there are options to get the standard, metric or imperial units. Hence
        * if there is a need to have any particular value in different unit type, so it can be converted
        * using this method.
        */
        fun convertMeterPerSecondToMilePerHour(value:Double):Double{
            return value * 2.237
        }
    }
}