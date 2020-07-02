package pl.project.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.model.dto.WeatherDto;
import pl.project.service.WeatherService;

@CrossOrigin()
@RestController
@RequestMapping("/api/")
public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "weather",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherDto getWeather() {
        return weatherService.getWeather();
    }
}

