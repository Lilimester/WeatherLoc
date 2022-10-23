package com.weatherloc.weatherloclib_jkp.open.enum

/**
 * Below enums represents the type of values in which you would wish to
 * have the data i.e. values in kelvin, celsius, fahreinheit or meters/sec,
 * miles/hours etc.
 *
 * Under [STANDARD] : temperature will be in kelvin and speed will be in
 *                    meters/second.
 *
 * Under [METRIC] : temperature will be in celsius and speed will be in
 *                    meters/second.
 *
 * Under [IMPERIAL] : temperature will be in Fahrenheit and speed will be in
 *                    miles/hour.
 *
 * For individual data conversion, [WeatherLoc] has methods to convert data into
 * desired format.
 * */
enum class TemperatureUnitType(val value:String) {

    /**
     * For this unit type, temperature values will be in kelvin and speed values will be in meters/second.
     * */
    STANDARD("null"),

    /**
     * For this unit type, temperature values will be in celsius and speed values will be in meters/second.
     * */
    METRIC("metric"),

    /**
     * For this unit type, temperature values will be in Fahrenheit and speed values will be in miles/hour.
     * */
    IMPERIAL("imperial"),
}