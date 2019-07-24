package pl.project.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeoLocalizationService geoLocalization;
    private static final String ERROR_RUNTIME = "Runtime exception";

    public WeatherService(GeoLocalizationService geoLocalization) {
        this.geoLocalization = geoLocalization;
    }

    public String getWeatherFromApi() {
        String output = "";
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://api.openweathermap.org/data/2.5/weather?q="
                    + geoLocalization.getLocation().getCity() + "&units=metric"
                    + "&APPID=f071f2aeda64cdae04b49c962b676f9a");

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException(ERROR_RUNTIME);
            }

            output = response.getEntity(String.class);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return output;
    }

}
