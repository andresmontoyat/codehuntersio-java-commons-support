package io.codehunters.commons.util.ip.http.client.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * visit to https://ipapi.co/#api for more information
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpLocation {

    public static String IP_API_STATUS_SUCCESS = "success";
    public static String IP_API_STATUS_FAILURE = "fail";
    public static final String LOCATION_UNKNOWN = "UNKNOWN";

    @JsonProperty("query")
    private String ip;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("city")
    private String city;

    @JsonProperty("region")
    private String region;

    @JsonProperty("regionName")
    private String regionName;

    @JsonProperty("country")
    private String country;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("continent")
    private String continent;

    @JsonProperty("district")
    private String district;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("isp")
    private String ispName;

    @JsonProperty("org")
    private String organization;

    @JsonProperty("reverse")
    private String reverse;

    @JsonProperty("mobile")
    private Boolean mobile;

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lon")
    private Double longitude;

    @JsonProperty("proxy")
    private Boolean proxy;

}
