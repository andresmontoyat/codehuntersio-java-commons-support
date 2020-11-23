package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class HashIdProperties {

    private String salt;

    private int minLength;
}
