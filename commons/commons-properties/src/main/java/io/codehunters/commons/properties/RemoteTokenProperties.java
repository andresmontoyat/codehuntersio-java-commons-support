package io.codehunters.commons.properties;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RemoteTokenProperties {

    private String clientId;

    private String clientSecret;

    private TokenProperties token;

    private String checkTokenEndpoint;

    private String tokenEndpoint;

    private String authorizeEndpoint;
}
