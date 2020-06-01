package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteTokenProperties {

    private String clientId;

    private String clientSecret;

    private TokenProperties token;

    private String checkTokenEndpoint;

    private String tokenEndpoint;

    private String authorizeEndpoint;
}
