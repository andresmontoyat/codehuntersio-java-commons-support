package io.codehunters.commons.repository.audit.support.domain;

import io.codehunters.commons.repository.converter.MapStringKeyWithObjectValueConverter;
import io.codehunters.commons.repository.domain.support.JpaEntities;
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
@Table(name = "commons_audit_log")
public class Audit extends JpaEntities<Long> {

    @Column(name = "commons_audit_type", nullable = false, length = 80)
    private String type;

    @Column(name = "commons_audit_username", nullable = false, length = 120)
    private String username;

    @Column(name = "commons_audit_message", length = 400)
    private String message;

    @Column(name = "commons_audit_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_audit_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_audit_parameter_3", length = 200)
    private String parameter3;

    @Column(name = "commons_audit_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithObjectValueConverter.class)
    private Map<String, Object> additionalInfo;

}
