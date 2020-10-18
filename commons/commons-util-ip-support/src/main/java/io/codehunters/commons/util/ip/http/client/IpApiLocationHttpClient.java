package io.codehunters.commons.util.ip.http.client;

import io.codehunters.commons.util.ip.http.client.support.IpLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
public class IpApiLocationHttpClient {

    public static String IP_API_URL = "http://ip-api.com/json/%s?fields=status,message,continent,continentCode,country,countryCode,region,regionName,city,district,zip,lat,lon,timezone,currency,isp,org,as,reverse,mobile,proxy,hosting,query";

    public static IpLocation call(String ip) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<IpLocation> response = restTemplate.getForEntity(URI.create(String.format(IP_API_URL, ip)), IpLocation.class);
            if (HttpStatus.OK.equals(response.getStatusCode())) {
                IpLocation ipLocation = response.getBody();
                if (IpLocation.IP_API_STATUS_SUCCESS.equals(ipLocation.getStatus())) {
                    return ipLocation;
                }

                log.error(String.format("An error has occurred trying to search the ip location in http://ip-api.com/. %s", ipLocation.getMessage()));
            }
        } catch (Exception e) {
            log.error("An error has occurred trying to search the ip location in http://ip-api.com/.", e);
        }

        IpLocation defaultIpLocation = new IpLocation();
        defaultIpLocation.setIp(ip);
        defaultIpLocation.setStatus(IpLocation.IP_API_STATUS_FAILURE);
        return defaultIpLocation;
    }
}
