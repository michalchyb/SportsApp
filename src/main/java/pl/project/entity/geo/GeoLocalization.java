package pl.project.entity.geo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.net.InetAddress;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeoLocalization {
    private InetAddress ipAddress;
    private String city;
    private String latitude;
    private String longitude;
}
