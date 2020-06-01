package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AWSProperties {

    private String accessKey;

    private String secretKey;

    private String region;
}
