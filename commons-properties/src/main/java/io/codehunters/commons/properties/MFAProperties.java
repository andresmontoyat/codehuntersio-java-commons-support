package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MFAProperties {

    private Boolean enabled;

    private String secret;

    private int interval;
}
