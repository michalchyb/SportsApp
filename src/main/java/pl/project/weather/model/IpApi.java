package pl.project.weather.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IpApi {

    @Value("${ip.api.url}")
    private String url;

    @Value("${ip.api.key}")
    private String apiKey;

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }
}
