package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HashIdProperties {

    private String salt;

    private int minLength;
}
