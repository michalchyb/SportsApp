package pl.project.utils.geo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.project.SportsApp;
import pl.project.entity.Run;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class GeoHelpers {
    private static final Logger logger = LogManager.getLogger(SportsApp.class);
    private static final String URL_NAME = "http://bot.whatismyipaddress.com";
    private static final String ERROR_EXECUTION = "Cannot Execute";

    public static String getHostIpAddress() throws UnknownHostException {

        InetAddress localhost = InetAddress.getLocalHost();
        String hostIpAddress = "";

        try {
            URL urlName = new URL(URL_NAME);

            try (BufferedReader sc = new BufferedReader(new InputStreamReader(urlName.openStream()))) {
                hostIpAddress = sc.readLine().trim();
            }
        } catch (Exception e) {
            hostIpAddress = ERROR_EXECUTION;
        }
        return hostIpAddress;
    }
}


