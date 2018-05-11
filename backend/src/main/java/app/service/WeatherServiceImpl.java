package app.service;

import app.config.AppConfig;
import app.exception.ApplicationException;
import app.exception.WeatherApiParsingException;
import app.model.Weather;
import app.utils.WeatherApiConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherServiceImpl implements WeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);

    private static final String WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String WEATHER_API_SUFFIX = "&units=%s&APPID=%s";

    private AppConfig appConfig;
    private RestTemplate restTemplate;
    private WeatherApiConverter weatherApiConverter;

    @Autowired
    public WeatherServiceImpl(AppConfig appConfig, RestTemplate restTemplate, WeatherApiConverter weatherApiConverter) {
        this.appConfig = appConfig;
        this.restTemplate = restTemplate;
        this.weatherApiConverter = weatherApiConverter;
    }

    @Override
    public Weather getWeatherByCityName(String cityName) throws ApplicationException {

        String WeatherSuffixCompleted = String.format(WEATHER_API_SUFFIX, appConfig.getUnits(), appConfig.getAppid());
        String fullWeatherApiUrl = WEATHER_API_URL + cityName + WeatherSuffixCompleted;

        ResponseEntity<String> response = restTemplate.getForEntity(fullWeatherApiUrl, String.class);

        try {
            return weatherApiConverter.convertToWeather(response.getBody());
        } catch (WeatherApiParsingException e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}
