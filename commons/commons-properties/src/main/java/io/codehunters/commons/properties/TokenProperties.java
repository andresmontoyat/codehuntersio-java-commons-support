package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class TokenProperties {

    private boolean supportRefreshToken;

    private int accessTokenValiditySeconds;

    private int refreshTokenValiditySeconds;

    private boolean reuseRefreshToken;
}
