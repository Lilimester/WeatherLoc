# WeatherLoc
A sdk for fetching the weather for currnet time, 5 days time and specified duaration of time for specific location.

This class helps in obtaining the weather information for current, 5 days as well as for the specified duration
of the time. The initialization of the class requires two data among them, one is mandatory and other
one is non mandatory.
 
Required parameter:
     context of type Context - Interface to global information about an application environment.  This is
                        an abstract class whose implementation is provided by the Android system.
                        It allows access to application-specific resources and classes, as well as
                        up-calls for application-level operations such as launching activities broadcasting
                        and receiving intents, etc.
 
Non mandatory optional parameter:
       mUnitType of type TemperatureUnitType [Enum] - This parameter accepts the enum stating the unit type
       which you would require.
           TemperatureUnitType.STANDARD: This unit type division involves the temperature type as kelvin and
               for speed, the unit type is meters/second.
           TemperatureUnitType.METRIC: This unit type division involves the temperature type as celsius and
               for speed, the unit type is meters/second.
           TemperatureUnitType.IMPERIAL: This unit type division involves the temperature type as fahrenheit and
               for speed, the unit type is meters/second.
 
Instance for WeatherLoc which is being created with above optional unit type param will provide the data
of weather in mentioned unit type.
 
In case of changing the particular data or field to other data type for usage, other provided conversion methods 
could be utlized.

## For fetching the current weather information use below method.

WeatherLoc(this).obtainCurrentWeatherByLatLng(
            context,  //<- pass context
            44.34,   //<- Latitude of the location whose weather required
            10.98,   //<- Longitude of the location whose weather required
            {weather ->  },   //<- A block providing the callback with weather data.
            {exception ->  }   //<- A block providing the callback with exception if no data is found.
        )
        
## For fetching 5-day weather overview.

weatherLoc.obtainFiveDaysWeatherByLatLng(
            context,  //<- pass context
            44.34,   //<- Latitude of the location whose weather required
            10.98,   //<- Longitude of the location whose weather required
            {weather ->  },   //<- A block providing the callback with weather data.
            {exception ->  }   //<- A block providing the callback with exception if no data is found.
        )
        
## For fetching the weather information for specific duration in future, from 1 to maximum 16 days.

weatherLoc.obtainFutureWeatherByLatLng(
                context,  //<- pass context
                44.34,   //<- Latitude of the location whose weather required
                10.98,   //<- Longitude of the location whose weather required
                mEdtDaysCount.text.toString().toInt(),   //<- Number of days indicating the amount of days whose weather is required.
                {weather ->  },   //<- A block providing the callback with weather data.
                {exception ->  }   //<- A block providing the callback with exception if no data is found.
            )
 
 # Conversions.
 
 ## Below are the conversion methods for unittype. all methods exception getCountryName returns double value. getCountryName returns string.
 
 ## For conversion of value from kelvin to celsius
 
 WeatherLoc.convertKelvinToCelsius(value: Double?)
 
 ## For conversion of value from kelvin to fahrenheit
 
 WeatherLoc.convertKelvinToFahrenheit(value: Double?)
 
 ## For conversion of value from celsius to kelvin
 
 WeatherLoc.convertCelsiusToKelvin(value: Double?)
 
 ## For conversion of value from celsius to fahrenheit
 
 WeatherLoc.convertCelsiusToFahrenheit(value: Double?)

 ## For conversion of value from fahrenheit to kelvin
 
 WeatherLoc.convertFahrenheitToKelvin(value: Double?)
 
 ## For conversion of value from fahrenheit to celsius
 
 WeatherLoc.convertFahrenheitToCelsius(value: Double?)

 ## For conversion of value from meters/second to miles/hour
 
 WeatherLoc.convertMeterPerSecondToMilePerHour(value: Double?)
 
 ## For conversion of value from miles/hour to meters/second
 
 WeatherLoc.convertMilePerHourToMeterPerSecond(value: Double?)
 
 ## For fetching the country name from country code.
 
 WeatherLoc.getCountryName(value: String?)
