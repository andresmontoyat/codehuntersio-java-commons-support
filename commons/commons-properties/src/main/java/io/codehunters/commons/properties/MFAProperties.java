package io.codehunters.commons.properties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MFAProperties {

    private Boolean enabled;

    private String secret;

    private int interval;
}
