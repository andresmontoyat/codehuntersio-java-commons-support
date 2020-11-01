package io.codehunters.commons.properties;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HashIdProperties {

    private String salt;

    private int minLength;
}
