package io.codehunters.commons.util.device.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class DeviceInfo {

    private Long serialId;

    private String location;

    private String ip;

    private String userAgent;

    private Double latitude;

    private Double longitude;

    private Map<String, Object> additionalInfo;

    public DeviceInfo addAdditionalInfo(String key, Object value) {
        if(this.additionalInfo == null) {
            this.additionalInfo = new HashMap<String, Object>();
        }

        this.additionalInfo.put(key, value);
        return this;
    }
}
