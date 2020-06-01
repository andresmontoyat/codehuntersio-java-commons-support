package io.codehunters.commons.repository.devicemetadata.support.domain;

import io.codehunters.commons.enums.device.support.DeviceMetadataStatus;
import io.codehunters.commons.repository.domain.support.Geolocation;
import io.codehunters.commons.repository.domain.support.converter.MapStringKeyWithObjectValueConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_devices_metadata")
public class DeviceMetadata extends Geolocation<Long> {

    @Enumerated(EnumType.STRING)
    @Column(name = "commons_device_status", nullable = false, length = 20)
    private DeviceMetadataStatus status;

    @Column(name = "commons_device_username", nullable = false, length = 80)
    private String username;

    @Column(name = "commons_device_serial_id", length = 200)
    private Long serialId;

    @Column(name = "commons_device_details", length = 400)
    @Convert(converter = MapStringKeyWithObjectValueConverter.class)
    private Map<String, Object> additionalInfo;

    @Column(name = "commons_device_location", length = 200)
    private String location;

    @Column(name = "commons_device_user_agent", length = 200)
    private String userAgent;

    @Column(name = "commons_device_ip", length = 200)
    private String ip;

    @Column(name = "commons_device_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_device_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_device_parameter_3", length = 200)
    private String parameter3;

}
