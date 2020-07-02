package pl.project.model.dto;

import lombok.Builder;


@Builder
public class LocalizationDto {
    private String ip;
    private String city;
    private Double latitude;
    private Double longitude;

    public String getIp() {
        return ip;
    }

    public String getCity() {
        return city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
