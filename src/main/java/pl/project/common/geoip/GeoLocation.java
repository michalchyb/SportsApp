package pl.project.common.geoip;

import com.maxmind.geoip.Location;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeoLocation {

    private String countryCode;
    private String countryName;
    private String postalCode;
    private String city;
    private String region;
    private int areaCode;
    private int dmaCode;
    private int metroCode;
    private float latitude;
    private float longitude;

    public static GeoLocation map(Location loc) {
        return new GeoLocation(loc.countryCode, loc.countryName, loc.postalCode, loc.city, loc.region, loc.area_code,
                loc.dma_code, loc.metro_code, loc.latitude, loc.longitude);
    }

}