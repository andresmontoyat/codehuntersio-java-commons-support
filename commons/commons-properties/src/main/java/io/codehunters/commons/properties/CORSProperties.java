package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CORSProperties {

    @Builder.Default
    private String path = "/**";

    @Builder.Default
    private Boolean allowCredentials = false;

    @Builder.Default
    private String origins = "*";

    @Builder.Default
    private String headers = "*";

    private String exposedHeaders;

    @Builder.Default
    private String methods = "GET,POST";

    @Builder.Default
    private Integer maxAge = 3600;
}
