package pl.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.project.model.City;
import pl.project.model.OpenWeatherApi;
import pl.project.model.weather.WeatherObject;
import pl.project.repository.CityRepository;

import java.util.Optional;


@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private RestTemplate restTemplate;
    private OpenWeatherApi openWeatherApi;

    public CityServiceImpl(CityRepository cityRepository, RestTemplate restTemplate, OpenWeatherApi openWeatherApi) {
        this.cityRepository = cityRepository;
        this.restTemplate = restTemplate;
        this.openWeatherApi = openWeatherApi;
    }

    @Override
    public Optional<City> setCorrectCity(String name) {
        Optional<City> city = cityRepository.findByName(name);
        if (!city.isPresent()) {
            City distinctCity = new City();
            setCoordinates(name, distinctCity);
            cityRepository.save(distinctCity);
            return Optional.of(distinctCity);
        }
        return city;
    }

    private void setCoordinates(String name, City distinctCity) {
        WeatherObject weather = getWeather(name);
        distinctCity.setName(name);
        distinctCity.setLongitude(weather.getCoord().getLon());
        distinctCity.setLatitude(weather.getCoord().getLat());
    }


    private WeatherObject getWeather(String name) {
        return restTemplate.getForObject(openWeatherApi.getUrl() + name + openWeatherApi.getApiKey() + openWeatherApi.getUnit(), WeatherObject.class);
    }
}
