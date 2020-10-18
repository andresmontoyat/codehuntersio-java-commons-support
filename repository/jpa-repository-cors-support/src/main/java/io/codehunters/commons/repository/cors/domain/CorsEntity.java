package io.codehunters.commons.repository.cors.domain;

import io.codehunters.commons.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.repository.converter.SetStringConverter;
import io.codehunters.commons.repository.domain.JpaEntities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_security_cors")
public class CorsEntity extends JpaEntities<Long> {

    @Column(name = "commons_cors_client_id", nullable = false)
    private Long clientId;

    @Column(name = "commons_cors_urls", length = 400)
    @Convert(converter = SetStringConverter.class)
    private Set<String> urls;

    @Column(name = "commons_cors_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_cors_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_cors_parameter_3", length = 200)
    private String parameter3;

    @Column(name = "commons_cors_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;
}
