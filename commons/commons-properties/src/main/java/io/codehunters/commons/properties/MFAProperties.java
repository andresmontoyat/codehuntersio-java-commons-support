package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MFAProperties {

    private Boolean enabled;

    private String secret;

    private int interval;
}
