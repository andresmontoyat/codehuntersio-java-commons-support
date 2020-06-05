package io.codehunters.commons.repository.audit.support.domain;

import io.codehunters.commons.repository.domain.support.Entities;
import io.codehunters.commons.repository.domain.support.converter.MapStringKeyWithObjectValueConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_audit_log")
public class Audit extends Entities<Long> {

    @Column(name = "commons_audit_event_type", nullable = false, length = 80)
    private String eventType;

    @Column(name = "commons_audit_username", nullable = false, length = 80)
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "commons_audit_session_date")
    private Date sessionDate;

    @Column(name = "commons_audit_req_session_id", length = 60)
    private String requestedSessionId;

    @Column(name = "commons_audit_remote_addr", length = 60)
    private String remoteAddr;

    @Column(name = "commons_audit_remote_host")
    private String remoteHost;

    @Column(name = "commons_audit_message", length = 400)
    private String message;

    @Column(name = "commons_audit_add_info", length = 200)
    @Convert(converter = MapStringKeyWithObjectValueConverter.class)
    private Map<String, Object> additionalInfo;

    @Column(name = "commons_audit_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_audit_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_audit_parameter_3", length = 200)
    private String parameter3;

}
