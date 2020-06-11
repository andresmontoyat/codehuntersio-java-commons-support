package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashIdProperties {

    private String salt;

    private int minLength;
}
