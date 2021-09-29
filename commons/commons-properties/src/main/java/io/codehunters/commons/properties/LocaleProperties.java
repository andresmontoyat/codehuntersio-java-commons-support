package io.codehunters.commons.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class LocaleProperties {

    public static final String COOKIE_RESOLVER = "cookie";
    public static final String SESSION_RESOLVER = "cookie";
    public static final String HEADER_RESOLVER = "header";

    @Builder.Default
    private String resolver = COOKIE_RESOLVER;
}
