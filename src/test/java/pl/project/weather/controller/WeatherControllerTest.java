package pl.project.weather.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.project.weather.model.dto.WeatherDto;
import pl.project.weather.service.WeatherService;

import javax.ws.rs.core.MediaType;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void getWeatherDto() throws Exception {

        WeatherDto weatherDto = prepareWeatherDto();
        given(weatherService.getWeather()).willReturn(weatherDto);
        mvc.perform(get("/api/weather")
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJyb2xlIjoiUk9MRV9VU0VSIn0.PgHKX1jT_fEhrFE1xWPDvxwOtVKJFa2rT4Gd0Zw0h8A")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.weather").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.weatherIcon").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.temp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pressure").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.minTemp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.maxTemp").exists())

                .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.weather").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.weatherIcon").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.temp").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pressure").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.minTemp").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.maxTemp").isNotEmpty())

                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Luboń"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.weather").value("Clear"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.weatherIcon").value("01d"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.temp").value(21.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pressure").value(1023.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.minTemp").value(18.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.maxTemp").value(22.0));

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