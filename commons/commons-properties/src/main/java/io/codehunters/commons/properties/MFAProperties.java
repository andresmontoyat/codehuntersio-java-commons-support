package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MFAProperties {

    private Boolean enabled;

    private String secret;

    private int interval;
}
