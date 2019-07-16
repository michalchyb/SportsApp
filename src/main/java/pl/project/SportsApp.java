package pl.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.project.utils.geo.GeoHelpers;

import java.net.UnknownHostException;

@SpringBootApplication
public class SportsApp {

    public static void main(String[] args) throws UnknownHostException {

        SpringApplication.run(SportsApp.class, args);
        GeoHelpers.getCurrentIpAddress();

    }
}
