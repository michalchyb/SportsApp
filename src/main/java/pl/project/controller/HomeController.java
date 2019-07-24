package pl.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.entity.geo.GeoLocalization;
import pl.project.entity.weather.WeatherObject;
import pl.project.service.GeoLocalizationService;
import pl.project.service.WeatherService;
import pl.project.utils.geo.GeoHelpers;
import pl.project.utils.geo.WeatherHelpers;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class HomeController {

    private GeoLocalizationService geoLocalization;
    private WeatherService weatherService;

    public HomeController(GeoLocalizationService geoLocalization, WeatherService weatherService) {
        this.geoLocalization = geoLocalization;
        this.weatherService = weatherService;
    }

    @GetMapping("location")
    public GeoLocalization getLocation() throws IOException, GeoIp2Exception {
        return geoLocalization.getLocation();
    }

    @GetMapping("weather")
    public StringBuilder getWeatherForLocalization() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String weatherOutput = weatherService.getWeatherFromApi();
        WeatherObject weatherObject = objectMapper.readValue(weatherOutput, WeatherObject.class);

        return WeatherHelpers.printWeatherForLocation(weatherObject);

    }

}
