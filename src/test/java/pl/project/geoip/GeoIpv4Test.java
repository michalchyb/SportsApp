package pl.project.geoip;

import org.junit.Test;
import pl.project.commons.GeoHelpers;
import pl.project.commons.geoip.GeoIPv4;

import static org.junit.Assert.*;

public class GeoIpv4Test {

    private static final String CITY_POZNAN = "Poznan";
    private static final String CITY_NEW_YORK = "New York";

    @Test
    public void test_001() {
        assertEquals(CITY_POZNAN, GeoIPv4.getLocation(GeoHelpers.getHostIpAddress()).getCity());
    }

    @Test
    public void test_002() {
        assertEquals(CITY_NEW_YORK, GeoIPv4.getLocation("72.229.28.185").getCity());
    }

}
