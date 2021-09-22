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
public class WebSecurityProperties {

    @Builder.Default
    private LoginProperties login = LoginProperties.builder().build();

    private String[] ignore;

    private String[] secure;
}
