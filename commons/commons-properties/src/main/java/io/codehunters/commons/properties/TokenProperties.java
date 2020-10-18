package io.codehunters.commons.properties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenProperties {

    private boolean supportRefreshToken;

    private int accessTokenValiditySeconds;

    private int refreshTokenValiditySeconds;

    private boolean reuseRefreshToken;
}
