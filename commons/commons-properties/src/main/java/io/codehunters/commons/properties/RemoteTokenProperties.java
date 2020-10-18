package io.codehunters.commons.properties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoteTokenProperties {

    private String clientId;

    private String clientSecret;

    private TokenProperties token;

    private String checkTokenEndpoint;

    private String tokenEndpoint;

    private String authorizeEndpoint;
}
