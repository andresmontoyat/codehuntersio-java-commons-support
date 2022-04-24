package io.codehunters.commons.util.device.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@SuppressWarnings("unchecked")
public class Device implements Serializable {

    private static final long serialVersionUID = -6403639730258737259L;

    private Long serialId;

    private String location;

    private String ip;

    private String userAgent;

    private Double latitude;

    private Double longitude;

    private java.util.Map<String, Serializable> additionalInfo;

    public Device addAdditionalInfo(String key, Serializable value) {
        if(this.additionalInfo == null) {
            this.additionalInfo = new java.util.HashMap<>();
        }

        this.additionalInfo.put(key, value);
        return this;
    }
}
