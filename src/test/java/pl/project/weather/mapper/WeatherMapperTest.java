package pl.project.weather.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.project.weather.model.dto.WeatherDto;
import pl.project.weather.model.weather.Main;
import pl.project.weather.model.weather.Weather;
import pl.project.weather.model.weather.WeatherObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherMapperTest {

    private WeatherMapper weatherMapper;

    @Before
    public void setup() {
        weatherMapper = new WeatherMapper();
    }

    @Test
    public void test_map_entity_to_dto() {

        // given
        WeatherObject weatherObject = prepareWeatherObject();
        // when
        WeatherDto weatherDto = weatherMapper.map(weatherObject);

        Assert.assertEquals("Clear", weatherDto.getWeather());
        Assert.assertEquals("01d", weatherDto.getWeatherIcon());
        Assert.assertEquals(20.0, weatherDto.getTemp(), 2);
        Assert.assertEquals(1027.0, weatherDto.getPressure(), 2);
        Assert.assertEquals(20.0, weatherDto.getMinTemp(), 2);
        Assert.assertEquals(18.0, weatherDto.getMaxTemp(), 2);

    }

    private WeatherObject prepareWeatherObject() {
        List<Weather> weather = prepareWeather();
        Main main = prepareMain();
        return WeatherObject.builder()
                .name("Luboń")
                .weather(weather)
                .main(main)
                .build();
    }

    private List<Weather> prepareWeather() {
        List<Weather> list = new ArrayList<>();
        Weather weather = new Weather(800, "Clear", "clear sky", "01d");
        list.add(weather);
        return list;
    }

    private Main prepareMain() {
        return Main.builder()
                .temp(20.0)
                .pressure(1027.0)
                .humidity(20)
                .tempMin(18.0)
                .tempMax(20.0)
                .build();
    }
}