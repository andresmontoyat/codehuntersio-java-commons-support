package io.codehunters.commons.properties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceServerProperties {

    private String id;
    
    private JWTProperties jwt;
}
