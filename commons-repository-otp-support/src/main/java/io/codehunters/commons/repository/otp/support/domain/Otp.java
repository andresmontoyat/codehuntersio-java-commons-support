package io.codehunters.commons.repository.otp.support.domain;

import io.codehunters.commons.enums.otp.support.OtpServiceType;
import io.codehunters.commons.enums.otp.support.OtpStatus;
import io.codehunters.commons.repository.domain.support.Entities;
import io.codehunters.commons.repository.domain.support.converter.MapStringKeyWithObjectValueConverter;
import io.codehunters.commons.repository.otp.support.domain.support.converter.OtpServiceTypeConverter;
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
public class Otp extends Entities<Long> {

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
    private OtpStatus otpStatus;

    @Convert(converter = OtpServiceTypeConverter.class)
    @Column(name = "commons_otp_service_type", nullable = false, length = 80)
    private List<OtpServiceType> otpServiceType;

    @Column(name = "commons_otp_failed_attempts", nullable = false)
    private Integer failedAttempts;

    @Column(name = "commons_otp_additional_info", length = 400)
    @Convert(converter = MapStringKeyWithObjectValueConverter.class)
    private Map<String, Object> additionalInfo;

    @Column(name = "commons_otp_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_otp_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_otp_parameter_3", length = 200)
    private String parameter3;
}
