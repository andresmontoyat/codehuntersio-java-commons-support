package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenProperties {

    private boolean supportRefreshToken;

    private int accessTokenValiditySeconds;

    private int refreshTokenValiditySeconds;

    private boolean reuseRefreshToken;
}
