package pl.project.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.entity.geo.GeoLocalization;
import pl.project.service.GeoLocalizationService;
import pl.project.utils.geo.GeoHelpers;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class HomeController {

    private GeoLocalizationService geoLocalization;

    public HomeController(GeoLocalizationService geoLocalization) {
        this.geoLocalization = geoLocalization;
    }

    @GetMapping("location")
    public GeoLocalization getLocation() throws IOException, GeoIp2Exception {

        return geoLocalization.getLocation(GeoHelpers.getHostIpAddress());
    }
}
