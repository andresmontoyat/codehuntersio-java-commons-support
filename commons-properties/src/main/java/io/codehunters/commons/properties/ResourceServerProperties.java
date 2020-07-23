package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceServerProperties {

    private String id;
    
    private JWTProperties jwt;
}
