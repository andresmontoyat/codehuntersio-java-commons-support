package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Oauth2Properties {

    private ResourceServerProperties resource;
}
