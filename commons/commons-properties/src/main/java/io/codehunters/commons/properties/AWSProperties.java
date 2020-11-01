package io.codehunters.commons.properties;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AWSProperties {

    private String accessKey;

    private String secretKey;

    private String region;
}
