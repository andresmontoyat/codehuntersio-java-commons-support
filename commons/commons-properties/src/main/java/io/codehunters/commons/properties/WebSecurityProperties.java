package io.codehunters.commons.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSecurityProperties {

    private String ignore;

    private String secure;
}
