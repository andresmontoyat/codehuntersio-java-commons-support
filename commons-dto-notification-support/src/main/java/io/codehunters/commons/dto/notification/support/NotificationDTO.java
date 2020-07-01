package io.codehunters.commons.dto.notification.support;

import io.codehunters.commons.dto.notification.support.enums.DestinationType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class NotificationDTO {

    private String templateCode;

    private String source;

    private Map<DestinationType, List<String>> destinations;

    private Map<String, Object> params;

    public NotificationDTO addDestinations(DestinationType destinationType, List<String> value) {
        if (this.destinations == null) {
            this.destinations = new HashMap<>();
        }

        if (!this.destinations.containsKey(destinationType)) {
            this.destinations.put(destinationType, value);
        }

        return this;
    }

    public NotificationDTO addParam(String key, Object value) {
        if (this.params == null) {
            this.params = new HashMap<>();
        }

        if (!this.params.containsKey(key)) {
            this.params.put(key, value);
        }

        return this;
    }
}
