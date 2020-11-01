package io.codehunters.commons.properties;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenProperties {

    private boolean supportRefreshToken;

    private int accessTokenValiditySeconds;

    private int refreshTokenValiditySeconds;

    private boolean reuseRefreshToken;
}
