package io.codehunters.commons.jpa.repository.otp.domain;

import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.jpa.repository.domain.JpaEntities;
import io.codehunters.commons.jpa.repository.otp.domain.converter.ServiceTypeConverter;
import io.codehunters.commons.jpa.repository.otp.domain.enums.OtpServiceType;
import io.codehunters.commons.jpa.repository.otp.domain.enums.OtpStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_otps",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"commons_otp_code", "commons_otp_username", "commons_otp_sent_date"})
        })
public class OtpEntities extends JpaEntities<Long> {

    @Column(name = "commons_otp_code", nullable = false, length = 8)
    private String otp;

    @Column(name = "commons_otp_username", nullable = false, length = 80)
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "commons_otp_sent_date", nullable = false)
    private Date sentDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "commons_otp_ok_date")
    private Date okDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "commons_otp_invalidate_date")
    private Date invalidatedDate;

    @Column(name = "commons_otp_status", nullable = false, length = 20)
    private OtpStatus status;

    @Convert(converter = ServiceTypeConverter.class)
    @Column(name = "commons_otp_service_type", nullable = false, length = 80)
    private List<OtpServiceType> serviceTypes;

    @Column(name = "commons_otp_failed_attempts", nullable = false)
    private Integer failedAttempts;

    @Column(name = "commons_otp_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_otp_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_otp_parameter_3", length = 200)
    private String parameter3;

    @Column(name = "commons_otp_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;
}
