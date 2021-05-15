package io.codehunters.commons.jpa.repository.cors.domain;

import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.jpa.repository.converter.SetStringConverter;
import io.codehunters.commons.jpa.repository.domain.ParamsJpaEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "commons_security_cors")
public class CorsJpaEntities extends ParamsJpaEntity<Long> {

    @Column(name = "commons_cors_application", length = 200)
    private String application;

    @Column(name = "commons_cors_urls", length = 400)
    @Convert(converter = SetStringConverter.class)
    private Set<String> urls;

    @Column(name = "commons_cors_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;
}
