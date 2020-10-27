package io.codehunters.commons.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.core.io.Resource;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JWTProperties {

    private String signingKey;

    private Resource keyStore;

    private String keyStorePassword;

    private String keyPairAlias;

    private String keyPairPassword;

    private TokenProperties token;

}