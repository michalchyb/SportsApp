package pl.project.geoip;

import org.junit.Test;
import pl.project.commons.GeoHelpers;
import pl.project.commons.geoip.GeoIPv4;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;

public class GeoIpv4Test {

    @Test
    public void test_001() throws UnknownHostException {
        assertEquals("Poznan", GeoIPv4.getLocation(GeoHelpers.getHostIpAddress()).getCity());
    }

    @Test
    public void test_002() {
        assertEquals("New York", GeoIPv4.getLocation("72.229.28.185").getCity());
    }
}
