package io.codehunters.commons.jpa.repository.audit.domain;

import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.jpa.repository.domain.ParamsJpaEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "commons_audit_log")
public class AuditJpaEntities extends ParamsJpaEntity<Long> {

    @Column(name = "commons_audit_type", length = 80)
    private String type;

    @Column(name = "commons_audit_username", length = 120)
    private String username;

    @Column(name = "commons_audit_message", length = 400)
    private String message;

    @Column(name = "commons_audit_description", length = 800)
    private String description;

    @Column(name = "commons_audit_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;

}
