package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class WebSecurityProperties {

    @Builder.Default
    private LoginProperties login = LoginProperties.builder().build();

    private String[] ignore;

    private String[] secure;
}
