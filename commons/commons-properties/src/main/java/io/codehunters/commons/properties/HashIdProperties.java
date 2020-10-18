package io.codehunters.commons.properties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HashIdProperties {

    private String salt;

    private int minLength;
}
