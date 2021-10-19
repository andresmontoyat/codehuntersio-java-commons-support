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
public class LoginProperties {

    @Builder.Default
    private String loginPage = "/login";

    @Builder.Default
    private String username = "username";

    @Builder.Default
    private String password = "password";

    @Builder.Default
    private String loginProcessingUrl = "/perform_login";

    @Builder.Default
    private String loginSuccessUrl = "/account";

    @Builder.Default
    private String loginFailureUrl = "/login";

    @Builder.Default
    private String logoutUrl = "/login?logout=true";

    @Builder.Default
    private int sessionAttempts = 3;
}
