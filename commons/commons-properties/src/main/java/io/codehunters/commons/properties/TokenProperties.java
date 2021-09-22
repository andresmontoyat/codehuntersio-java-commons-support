package io.codehunters.commons.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class TokenProperties {

    @Builder.Default
    private boolean supportRefreshToken = false;

    @Builder.Default
    private long accessTokenValiditySeconds = 60;

    @Builder.Default
    private long refreshTokenValiditySeconds = 60;

    @Builder.Default
    private boolean reuseRefreshToken = false;
}
