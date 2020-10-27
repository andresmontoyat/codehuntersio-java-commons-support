package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadPoolProperties {

    private String threadName;

    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;
}
