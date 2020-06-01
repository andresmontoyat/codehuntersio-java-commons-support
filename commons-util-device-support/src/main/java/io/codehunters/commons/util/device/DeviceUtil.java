package io.codehunters.commons.util.device;

import io.codehunters.commons.util.device.dto.DeviceDTO;
import io.codehunters.commons.util.ip.IpUtil;
import lombok.extern.slf4j.Slf4j;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
public class DeviceUtil {

    public static final String HEADER_USER_AGENT = "User-Agent";

    public static DeviceDTO get(HttpServletRequest request) {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setIp(IpUtil.extractIp(request));
        Optional.ofNullable(IpUtil.extractLocation(request)).ifPresent(ipLocation -> {
            deviceDTO.setLocation(ipLocation.getCity());
            deviceDTO
                    .addAdditionalInfo("continent", ipLocation.getContinent())
                    .addAdditionalInfo("region", ipLocation.getRegion())
                    .addAdditionalInfo("country", ipLocation.getCountry())
                    .addAdditionalInfo("continentCode", ipLocation.getCountryCode())
                    .addAdditionalInfo("timezone", ipLocation.getTimezone())
                    .addAdditionalInfo("isp", ipLocation.getIspName())
                    .addAdditionalInfo("org", ipLocation.getOrganization())
                    .addAdditionalInfo("reverse", ipLocation.getReverse())
                    .addAdditionalInfo("mobile", ipLocation.getMobile());
            deviceDTO.setLatitude(ipLocation.getLatitude());
            deviceDTO.setLongitude(ipLocation.getLongitude());
        });
        Optional.ofNullable(getClient(request)).ifPresent(client -> {
            deviceDTO.setUserAgent(getUserAgent(client));
            deviceDTO.addAdditionalInfo("user-agent", client.toString());
        });

        return deviceDTO;
    }

    public static String getUserAgent(HttpServletRequest request) {
        Client client = getClient(request);
        if(client != null) {
            return getUserAgent(client);
        }
        return null;
    }

    public static String getUserAgent(Client client) {
        return String.format("%s.%s.%s|%s.%s.%s|%s", client.userAgent.family, client.userAgent.major, client.userAgent.minor,
                client.os.family, client.os.major, client.os.minor,
                client.device.family);
    }

    public static Client getClient(HttpServletRequest request) {
        try {
            Parser parser = new Parser();
            Client client = parser.parse(request.getHeader(HEADER_USER_AGENT));
            return client;
        } catch (Exception e) {
            log.error("An error has occurred trying to parser user-agent.", e);
        }
        return null;
    }
}