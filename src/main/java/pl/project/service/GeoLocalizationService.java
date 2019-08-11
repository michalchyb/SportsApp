package pl.project.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Service;
import pl.project.entity.geo.GeoLocalization;
import pl.project.utils.GeoHelpers;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class GeoLocalizationService {

    private static final String PATH_GEOLITECITY_DATABASE = "/home/michalch/IdeaProjects/SportsApp/src/main/resources/GeoLite2-City.mmdb";
    private DatabaseReader dataBaseReader;


    public GeoLocalizationService() throws IOException {
        File database = new File(PATH_GEOLITECITY_DATABASE);
        dataBaseReader = new DatabaseReader.Builder(database).build();
    }

    public GeoLocalization getLocation() throws IOException, GeoIp2Exception {

        InetAddress ipAddress = InetAddress.getByName(GeoHelpers.getHostIpAddress());
        CityResponse response = dataBaseReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude =
                response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();

        return new GeoLocalization(ipAddress, cityName, latitude, longitude);
    }
}
