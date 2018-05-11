package app.service;

import app.exception.ApplicationException;
import app.exception.WeatherApiParsingException;
import app.model.Weather;

public interface WeatherService {

    Weather getWeatherByCityName(String cityName) throws ApplicationException;
}
