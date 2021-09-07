package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class LoginProperties {

    @Builder.Default
    private String loginPage = "/login";

    @Builder.Default
    private String username = "username";

    @Builder.Default
    private String password = "password";

    @Builder.Default
    private String loginProcessingUrl = "/perform_login";
}
