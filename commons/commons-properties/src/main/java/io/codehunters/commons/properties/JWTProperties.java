package io.codehunters.commons.properties;

import lombok.*;
import org.springframework.core.io.Resource;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTProperties {

    private String signingKey;

    private Resource keyStore;

    private String keyStorePassword;

    private String keyPairAlias;

    private String keyPairPassword;

    private TokenProperties token;

}