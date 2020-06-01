package io.codehunters.commons.util.ip.http.client.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * visit to https://ipapi.co/#api for more information
 */
@Getter
@Setter
public class IpLocation {

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

}
