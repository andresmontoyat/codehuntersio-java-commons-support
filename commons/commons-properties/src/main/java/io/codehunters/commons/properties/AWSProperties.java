package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AWSProperties {

    private String accessKey;

    private String secretKey;

    private String region;
}
