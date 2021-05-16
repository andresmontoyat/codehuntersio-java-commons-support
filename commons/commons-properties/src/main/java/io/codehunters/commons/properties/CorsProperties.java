package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CorsProperties {

    private String path;

    private Boolean allowCredentials;

    private String origins;

    private String headers;

    private String exposedHeaders;

    private String methods;

    private String maxAge;
}
