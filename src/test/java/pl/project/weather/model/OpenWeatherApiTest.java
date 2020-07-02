package pl.project.weather.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.project.model.OpenWeatherApi;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherApiTest {

    @Autowired
    private OpenWeatherApi openWeatherApi;

    @Test
    public void test_get_value_from_application_properties_1() {
        String url = openWeatherApi.getUrl();
        Assert.assertEquals("http://api.openweathermap.org/data/2.5/weather?q=", url);
    }

    @Test
    public void test_get_value_from_application_properties_2() {
        String unit = openWeatherApi.getUnit();
        Assert.assertEquals("&units=metric", unit);
    }
}