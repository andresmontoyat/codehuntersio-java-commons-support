package io.codehunters.commons.properties;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WebSecurityProperties {

    private String ignore;

    private String secure;
}
