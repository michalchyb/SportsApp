package pl.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.project.mapper.WeatherMapper;
import pl.project.model.OpenWeatherApi;
import pl.project.model.dto.WeatherDto;
import pl.project.model.weather.WeatherObject;

@Service
public class WeatherService {
    private RestTemplate restTemplate;
    private LocalizationService localizationService;
    private WeatherMapper weatherMapper;
    private OpenWeatherApi openWeatherApi;

    public WeatherService(RestTemplate restTemplate, LocalizationService localizationService, WeatherMapper weatherMapper, OpenWeatherApi openWeatherApi) {
        this.restTemplate = restTemplate;
        this.localizationService = localizationService;
        this.weatherMapper = weatherMapper;
        this.openWeatherApi = openWeatherApi;
    }

    public WeatherDto getWeather() {
        WeatherObject weatherObject = restTemplate.getForObject(openWeatherApi.getUrl() + localizationService.getLocalization().getCity() + openWeatherApi.getApiKey() + openWeatherApi.getUnit(), WeatherObject.class);
        return weatherMapper.map(weatherObject);
    }
}

