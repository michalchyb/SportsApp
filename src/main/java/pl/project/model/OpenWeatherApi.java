package pl.project.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherApi {

    @Value("${open.weather.api.url}")
    private String url;

    @Value("${open.weather.api.key}")
    private String apiKey;

    @Value("${open.weather.api.unit}")
    private String unit;

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUnit() {
        return unit;
    }
}
