package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;

@Getter
@Setter
public class JWTProperties {

    private String signingKey;

    private Resource keyStore;

    private String keyStorePassword;

    private String keyPairAlias;

    private String keyPairPassword;

    private TokenProperties token;

}