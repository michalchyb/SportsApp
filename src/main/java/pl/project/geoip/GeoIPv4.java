package pl.project.geoip;

import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip.LookupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.project.SportsApp;

public class GeoIPv4 {
    private static final Logger logger = LogManager.getLogger(SportsApp.class);
    private static final String DATABASE_LOADED = "GeoIP Database loaded: ";
    private static final String ERROR_DATABASE_LOADING = "Could not load geo ip database: ";
    private static LookupService lookupService;

    static {
        try {
            lookupService = new LookupService(GeoIPv4.class.getResource("/GeoLiteCity.dat").getFile(),
                    LookupService.GEOIP_MEMORY_CACHE);

            logger.debug(DATABASE_LOADED + lookupService.getDatabaseInfo());
        } catch (IOException e) {
            logger.debug(ERROR_DATABASE_LOADING + e.getMessage());
        }
    }

    public static GeoLocation getLocation(String ipAddress) {
        return GeoLocation.map(lookupService.getLocation(ipAddress));
    }

    public static GeoLocation getLocation(long ipAddress) {
        return GeoLocation.map(lookupService.getLocation(ipAddress));
    }

    public static GeoLocation getLocation(InetAddress ipAddress) {
        return GeoLocation.map(lookupService.getLocation(ipAddress));
    }
}