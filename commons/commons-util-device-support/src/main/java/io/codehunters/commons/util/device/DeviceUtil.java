package io.codehunters.commons.util.device;

import io.codehunters.commons.util.device.dto.DeviceInfo;
import io.codehunters.commons.util.ip.IpUtil;
import io.codehunters.commons.util.ip.http.client.support.IpLocation;
import lombok.extern.slf4j.Slf4j;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
public class DeviceUtil {

    public static final String HEADER_USER_AGENT = "User-Agent";

    public static DeviceInfo get(HttpServletRequest request) {
        DeviceInfo deviceInfo = new DeviceInfo();

        IpLocation ipLocation = IpUtil.extractLocation(request);
        deviceInfo.setIp(ipLocation.getIp());
        if(IpLocation.IP_API_STATUS_SUCCESS.equals(ipLocation.getStatus())) {
            deviceInfo.setLocation(ipLocation.getCity());
            deviceInfo
                    .addAdditionalInfo("continent", ipLocation.getContinent())
                    .addAdditionalInfo("region", ipLocation.getRegion())
                    .addAdditionalInfo("country", ipLocation.getCountry())
                    .addAdditionalInfo("countryCode", ipLocation.getCountryCode())
                    .addAdditionalInfo("timezone", ipLocation.getTimezone())
                    .addAdditionalInfo("isp", ipLocation.getIspName())
                    .addAdditionalInfo("org", ipLocation.getOrganization())
                    .addAdditionalInfo("reverse", ipLocation.getReverse())
                    .addAdditionalInfo("mobile", ipLocation.getMobile())
                    .addAdditionalInfo("proxy", ipLocation.getProxy())
                    .addAdditionalInfo("zip", ipLocation.getZip())
                    .addAdditionalInfo("district", ipLocation.getDistrict())
                    .addAdditionalInfo("currency", ipLocation.getCurrency())
                    .addAdditionalInfo("ispName", ipLocation.getIspName());

            deviceInfo.setLatitude(ipLocation.getLatitude());
            deviceInfo.setLongitude(ipLocation.getLongitude());
        }

        Optional.ofNullable(getClient(request)).ifPresent(client -> {
            deviceInfo.setUserAgent(getUserAgent(client));
            deviceInfo.addAdditionalInfo("user-agent", client.toString());
        });

        return deviceInfo;
    }

    private static String getUserAgent(HttpServletRequest request) {
        Client client = getClient(request);
        if(client != null) {
            return getUserAgent(client);
        }
        return null;
    }

    private static String getUserAgent(Client client) {
        return String.format("%s.%s.%s|%s.%s.%s|%s", client.userAgent.family, client.userAgent.major, client.userAgent.minor,
                client.os.family, client.os.major, client.os.minor,
                client.device.family);
    }

    private static Client getClient(HttpServletRequest request) {
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