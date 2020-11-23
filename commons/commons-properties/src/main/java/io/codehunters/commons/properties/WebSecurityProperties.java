package io.codehunters.commons.properties;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class WebSecurityProperties {

    private List<String> ignore;

    private List<String> secure;
}
