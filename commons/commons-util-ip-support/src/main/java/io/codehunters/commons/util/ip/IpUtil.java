package io.codehunters.commons.util.ip;

import io.codehunters.commons.util.Util;
import io.codehunters.commons.util.ip.http.client.IpApiLocationHttpClient;
import io.codehunters.commons.util.ip.http.client.support.IpLocation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IpUtil {

    public static final String HEADER_X_FORWARDED_FOR = "x-forwarded-for";

    public static String extractIp(HttpServletRequest request) {
        return Util.isNull(request.getHeader(HEADER_X_FORWARDED_FOR)) ? request.getRemoteAddr() : parseXForwardedHeader(request.getHeader(HEADER_X_FORWARDED_FOR));
    }

    private static String parseXForwardedHeader(String header) {
        return header.split(" *, *")[0];
    }

    public static IpLocation extractLocation(HttpServletRequest request) {
        return extractLocation(extractIp(request));
    }

    public static IpLocation extractLocation(String ip) {
        return IpApiLocationHttpClient.call(ip);
    }
}
