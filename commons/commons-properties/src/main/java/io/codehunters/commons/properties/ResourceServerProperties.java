package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResourceServerProperties {

    private String id;
    
    private JWTProperties jwt;
}
