package io.codehunters.commons.repository.notification.domain;

import io.codehunters.commons.repository.converter.MapStringKeyWithObjectValueConverter;
import io.codehunters.commons.repository.domain.JpaEntities;
import io.codehunters.commons.repository.notification.domain.converter.DestinationTypeConverter;
import io.codehunters.commons.repository.notification.domain.enums.DestinationType;
import io.codehunters.commons.repository.notification.domain.enums.NotificationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_notifications")
public class Notification extends JpaEntities<Long> {

        @Enumerated(EnumType.STRING)
        @Column(name = "commons_notif_type", nullable = false, length = 80)
        private NotificationType type;

        @Column(name = "commons_notif_source", nullable = false, length = 120)
        private String source;

        @Column(name = "commons_notif_subject", length = 120)
        private String subject;

        @Column(name = "commons_notif_body", length = 800)
        private String body;

        @Column(name = "commons_notif_destinations", length = 400)
        @Convert(converter = DestinationTypeConverter.class)
        private Map<DestinationType, List<String>> destinations;

        @Column(name = "commons_notif_parameter_1", length = 200)
        private String parameter1;

        @Column(name = "commons_notif_parameter_2", length = 200)
        private String parameter2;

        @Column(name = "commons_notif_parameter_3", length = 200)
        private String parameter3;

        @Column(name = "commons_notif_additional_info", length = 800)
        @Convert(converter = MapStringKeyWithObjectValueConverter.class)
        private Map<String, Object> additionalInfo;
}