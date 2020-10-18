package io.codehunters.commons.properties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AWSProperties {

    private String accessKey;

    private String secretKey;

    private String region;
}
