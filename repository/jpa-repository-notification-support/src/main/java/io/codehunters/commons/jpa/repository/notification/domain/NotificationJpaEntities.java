package io.codehunters.commons.jpa.repository.notification.domain;

import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithListStringValueConverter;
import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.jpa.repository.domain.ParamsJpaEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "commons_notifications")
public class NotificationJpaEntities extends ParamsJpaEntity<Long> {

    @Column(name = "commons_notif_type", length = 80)
    private String type;

    @Column(name = "commons_notif_source", length = 120)
    private String source;

    @Column(name = "commons_notif_subject", length = 120)
    private String subject;

    @Column(name = "commons_notif_body", length = 4000)
    private String body;

    @Column(name = "commons_notif_destinations", length = 800)
    @Convert(converter = MapStringKeyWithListStringValueConverter.class)
    private Map<String, List<String>> destinations;

    @Column(name = "commons_notif_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;
}