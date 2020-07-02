package pl.project.weather.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.project.mapper.LocalizationMapper;
import pl.project.model.dto.LocalizationDto;
import pl.project.model.localization.Localization;

public class LocalizationMapperTest {

    private LocalizationMapper localizationMapper;

    @Before
    public void setup() {
        localizationMapper = new LocalizationMapper();
    }

    @Test
    public void test_map_entity_to_dto() {
        // given
        Localization localization = prepareLocalizationObject();
        // when
        LocalizationDto localizationDto = localizationMapper.map(localization);
        //then
        Assert.assertEquals("85.221.154.74", localizationDto.getIp());
        Assert.assertEquals("Września", localizationDto.getCity());
        Assert.assertEquals(52.27009963989258, localizationDto.getLatitude(), 2);
        Assert.assertEquals(17.551300048828125, localizationDto.getLongitude(), 2);

    }

    private Localization prepareLocalizationObject() {
        return Localization.builder()
                .ip("85.221.154.74")
                .city("Września")
                .latitude(52.27009963989258)
                .longitude(17.551300048828125)
                .build();
    }
}