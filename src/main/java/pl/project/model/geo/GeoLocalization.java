package pl.project.model.geo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.InetAddress;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocalization {

    private InetAddress ipAddress;
    private String city;
    private String latitude;
    private String longitude;
}
