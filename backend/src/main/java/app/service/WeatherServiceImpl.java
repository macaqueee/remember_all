package app.service;

import app.config.AppConfig;
import app.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherServiceImpl implements WeatherService {

    private static final String WEATHER_API_URL = "api.openweathermap.org/data/2.5/weather?q=";
    private static final String WEATHER_API_SUFFIX = "units=%s&APPID=%s";

    private AppConfig appConfig;
    private RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImpl(AppConfig appConfig, RestTemplate restTemplate) {
        this.appConfig = appConfig;
        this.restTemplate = restTemplate;
    }

    @Override
    public Weather getWeatherByCityName(String cityName) {
        String WeatherSuffixCompleted = String.format(WEATHER_API_SUFFIX, appConfig.getUnits(), appConfig.getAppid());
        String fullWeatherApiUrl = WEATHER_API_URL + cityName + WeatherSuffixCompleted;

        ResponseEntity<String> forEntity = restTemplate.getForEntity(fullWeatherApiUrl, String.class);
        return null;
    }
}
