package pl.project.weather.mapper;

import org.springframework.stereotype.Component;
import pl.project.weather.model.dto.WeatherDto;
import pl.project.weather.model.weather.WeatherObject;

@Component
public class WeatherMapper {

    public WeatherDto map(WeatherObject from) {
        return WeatherDto.builder()
                .name(from.getName())
                .weather(from.getWeather().get(0).getMain())
                .weatherIcon(from.getWeather().get(0).getIcon())
                .temp(from.getMain().getTemp())
                .pressure(from.getMain().getPressure())
                .minTemp(from.getMain().getTempMin())
                .maxTemp(from.getMain().getTempMax())
                .build();
    }
}
