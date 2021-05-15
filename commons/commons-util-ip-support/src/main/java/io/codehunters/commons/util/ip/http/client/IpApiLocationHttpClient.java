package io.codehunters.commons.util.ip.http.client;

import io.codehunters.commons.util.ip.http.client.support.IpLocation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IpApiLocationHttpClient {

    public static final String IP_API_URL = "http://ip-api.com/json/%s?fields=status,message,continent,continentCode,country,countryCode,region,regionName,city,district,zip,lat,lon,timezone,currency,isp,org,as,reverse,mobile,proxy,hosting,query";

    public static IpLocation call(String ip) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<IpLocation> response = restTemplate.getForEntity(URI.create(String.format(IP_API_URL, ip)), IpLocation.class);
            if (HttpStatus.OK.equals(response.getStatusCode())) {
                Optional<IpLocation> result = Optional.ofNullable(response.getBody());
                if (result.isPresent()) {

                    IpLocation ipLocation = response.getBody();
                    if (IpLocation.IP_API_STATUS_SUCCESS.equals(ipLocation.getStatus())) {
                        return ipLocation;
                    }
                }
                log.error(String.format("An error has occurred trying to search the ip location in http://ip-api.com/. %s", ip));
            }

            return IpLocation.builder().ip(ip).status(IpLocation.IP_API_STATUS_FAILURE).build();
        } catch (Exception e) {
            throw new IpApiLocationHttpClientException("An error has occurred trying to search the ip location in http://ip-api.com/.", e);
        }
    }
}
