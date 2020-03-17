package pl.project.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GeoHelpers {
    private static final String URL_NAME = "http://bot.whatismyipaddress.com";
    private static final String CAN_NOT_EXECUTE = "Can't Execute";

    public static String getHostIpAddress() {

        String hostIpAddress = "";

        try {
            URL urlName = new URL(URL_NAME);

            try (BufferedReader sc = new BufferedReader(new InputStreamReader(urlName.openStream()))) {
                hostIpAddress = sc.readLine().trim();
            }
        } catch (Exception e) {
            hostIpAddress = CAN_NOT_EXECUTE;
        }
        return hostIpAddress;
    }
}


