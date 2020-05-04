package pl.project.weather.mapper;

import org.decimal4j.util.DoubleRounder;
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
                .temp(DoubleRounder.round(from.getMain().getTemp(), 1))
                .pressure(from.getMain().getPressure())
                .minTemp(DoubleRounder.round(from.getMain().getTempMin(), 1))
                .maxTemp(DoubleRounder.round(from.getMain().getTempMax(), 1))
                .build();
    }
}
