package io.codehunters.commons.properties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadPoolProperties {

    private String threadName;

    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;
}
