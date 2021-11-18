package io.codehunters.commons.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.Resource;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class JWTProperties {

    private String signingKey;

    private boolean useKeyStore;

    private Resource keyStore;

    private String keyStorePassword;

    private String privateKeyAlias;

    private String privateKeyPassword;

    private String certificateAlias;

    private TokenProperties token;

}