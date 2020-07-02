package pl.project.mapper;

import org.springframework.stereotype.Component;
import pl.project.model.dto.LocalizationDto;
import pl.project.model.localization.Localization;

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
