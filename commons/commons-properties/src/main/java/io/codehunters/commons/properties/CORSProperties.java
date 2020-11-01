package io.codehunters.commons.properties;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CORSProperties {

    private String path;

    private Boolean allowCredentials;

    private String origins;

    private String headers;

    private String methods;

    private String maxAge;
}
