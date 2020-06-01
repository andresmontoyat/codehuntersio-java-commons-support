package io.codehunters.commons.properties;

import io.codehunters.commons.enums.security.support.TokenStoreType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceServerProperties {

    private String id;

    private TokenStoreType tokenStore;

    private JWTProperties jwt;
}
