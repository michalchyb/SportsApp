package pl.project.commons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GeoHelpers {
    private static final String URL_NAME = "http://bot.whatismyipaddress.com";
    private static final String ERROR_EXECUTION = "Cannot Execute";

    public static String getHostIpAddress() {

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


