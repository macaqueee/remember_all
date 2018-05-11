package app.service;

import app.model.Weather;

public interface WeatherService {

    Weather getWeatherByCityName(String cityName);
}
