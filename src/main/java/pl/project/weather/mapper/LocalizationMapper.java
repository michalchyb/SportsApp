package pl.project.weather.mapper;

import org.springframework.stereotype.Component;
import pl.project.weather.model.dto.LocalizationDto;
import pl.project.weather.model.localization.Localization;

@Component
public class LocalizationMapper {

    public LocalizationDto map(Localization from) {
        return LocalizationDto.builder()
                .ip(from.getIp())
                .city(from.getCity())
                .latitude(from.getLatitude())
                .longitude(from.getLongitude())
                .build();
    }
}
