package io.codehunters.commons.repository.devicemetadata.domain;

import io.codehunters.commons.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.repository.domain.JpaGeolocation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_devices_metadata")
public class DeviceMetadataEntity extends JpaGeolocation<Long> {

    @Column(name = "commons_device_status", nullable = false, length = 20)
    private String status;

    @Column(name = "commons_device_username", nullable = false, length = 120)
    private String username;

    @Column(name = "commons_device_serial_id", length = 200)
    private String serialId;

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

    @Column(name = "commons_device_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;
}
