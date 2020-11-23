package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ThreadPoolProperties {

    private String threadName;

    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;
}
