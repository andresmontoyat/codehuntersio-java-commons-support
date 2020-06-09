package io.codehunters.commons.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreadPoolProperties {

    private String threadName;

    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;
}
