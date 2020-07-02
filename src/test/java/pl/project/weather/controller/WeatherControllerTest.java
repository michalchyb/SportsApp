package pl.project.weather.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.project.controller.WeatherController;
import pl.project.model.dto.WeatherDto;
import pl.project.service.WeatherService;

import javax.ws.rs.core.MediaType;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void test_get_weather_success() throws Exception {

        WeatherDto weatherDto = prepareWeatherDto();
        given(weatherService.getWeather()).willReturn(weatherDto);
        mvc.perform(get("/api/weather")
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJyb2xlIjoiUk9MRV9VU0VSIn0.PgHKX1jT_fEhrFE1xWPDvxwOtVKJFa2rT4Gd0Zw0h8A")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.weather").exists())
                .andExpect(jsonPath("$.weatherIcon").exists())
                .andExpect(jsonPath("$.temp").exists())
                .andExpect(jsonPath("$.pressure").exists())
                .andExpect(jsonPath("$.minTemp").exists())
                .andExpect(jsonPath("$.maxTemp").exists())

                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.weather").isNotEmpty())
                .andExpect(jsonPath("$.weatherIcon").isNotEmpty())
                .andExpect(jsonPath("$.temp").isNotEmpty())
                .andExpect(jsonPath("$.pressure").isNotEmpty())
                .andExpect(jsonPath("$.minTemp").isNotEmpty())
                .andExpect(jsonPath("$.maxTemp").isNotEmpty())

                .andExpect(jsonPath("$.name").value("Luboń"))
                .andExpect(jsonPath("$.weather").value("Clear"))
                .andExpect(jsonPath("$.weatherIcon").value("01d"))
                .andExpect(jsonPath("$.temp").value(21.0))
                .andExpect(jsonPath("$.pressure").value(1023.0))
                .andExpect(jsonPath("$.minTemp").value(18.0))
                .andExpect(jsonPath("$.maxTemp").value(22.0));

    }

    private WeatherDto prepareWeatherDto() {
        return WeatherDto.builder()
                .name("Luboń")
                .weather("Clear")
                .weatherIcon("01d")
                .temp(21.0)
                .pressure(1023.0)
                .minTemp(18.0)
                .maxTemp(22.0)
                .build();
    }
}