package pl.project.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.project.SportsApp;
import pl.project.utils.geo.GeoHelpers;

@Service
public class WeatherService {

    private static final Logger logger = LogManager.getLogger(SportsApp.class);
    private GeoLocalizationService geoLocalization;

    public WeatherService(GeoLocalizationService geoLocalization) {
        this.geoLocalization = geoLocalization;
    }

    public String getWeatherFropApi() {
        String output = "";
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://api.openweathermap.org/data/2.5/weather?q="
                    + geoLocalization.getLocation(GeoHelpers.getHostIpAddress()).getCity() + "&units=metric"
                    + "&APPID=f071f2aeda64cdae04b49c962b676f9a");

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("error");
            }

            output = response.getEntity(String.class);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return output;
    }

}
