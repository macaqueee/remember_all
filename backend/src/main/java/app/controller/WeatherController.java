package app.controller;

import app.exception.ApplicationException;
import app.model.Weather;
import app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/getWeather", method = RequestMethod.GET)
    public Weather getWeatherByCityName(String cityName) throws ApplicationException {
        return weatherService.getWeatherByCityName(cityName);
    }
}
