package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class RemoteTokenProperties {

    private String clientId;

    private String clientSecret;

    private TokenProperties token;

    private String checkTokenEndpoint;

    private String tokenEndpoint;

    private String authorizeEndpoint;
}
