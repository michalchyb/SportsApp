package pl.project.controller;

import org.springframework.web.bind.annotation.*;
import pl.project.entity.geo.GeoLocalization;
import pl.project.service.GeoLocalizationService;
import pl.project.utils.geo.GeoHelpers;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class HomeController {

    public HomeController(GeoLocalizationService geoLocalizationService) throws IOException {
        geoLocalizationService = new GeoLocalizationService();
    }

    @PostMapping("/location")
    public GeoLocalization getLocation() throws Exception {

        GeoLocalizationService locationService = new GeoLocalizationService();
        return locationService.getLocation(GeoHelpers.getHostIpAddress());
    }
}
