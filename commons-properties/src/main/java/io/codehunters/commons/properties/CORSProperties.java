package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CORSProperties {

    private String path;

    private Boolean allowCredentials;

    private String origins;

    private String headers;

    private String methods;

    private String maxAge;
}
