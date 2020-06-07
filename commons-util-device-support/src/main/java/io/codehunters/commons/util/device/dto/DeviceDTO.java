package io.codehunters.commons.util.device.dto;

import io.codehunters.commons.dto.support.DTO;
import io.codehunters.commons.enums.device.support.DeviceMetadataStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@SuppressWarnings("unchecked")
public class DeviceDTO extends DTO<Long> {

    private DeviceMetadataStatus status;

    private String username;

    private Long serialId;

    private Map<String, Object> additionalInfo;

    private String location;

    private String ip;

    private String userAgent;

    private Double latitude;

    private Double longitude;

    private String parameter1;

    private String parameter2;

    private String parameter3;

    @Override
    public DeviceDTO withId(Long id) {
        super.setId(id);
        return this;
    }

    public DeviceDTO addAdditionalInfo(String key, Object value) {
        if(this.additionalInfo == null) {
            this.additionalInfo = new HashMap<String, Object>();
        }

        this.additionalInfo.put(key, value);
        return this;
    }
}
