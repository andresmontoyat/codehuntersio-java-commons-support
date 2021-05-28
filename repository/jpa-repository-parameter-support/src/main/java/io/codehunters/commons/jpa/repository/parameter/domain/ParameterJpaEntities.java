package io.codehunters.commons.jpa.repository.parameter.domain;

import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.jpa.repository.domain.JpaEntities;
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
@Table(name = "commons_parameters")
public class ParameterJpaEntities extends JpaEntities<Long> {

    @Column(name = "commons_param_group", nullable = false, length = 80)
    private String group;

    @Column(name = "commons_param_name", nullable = false, length = 80)
    private String name;

    @Column(name = "commons_param_code", unique = true, nullable = false, length = 80)
    private String code;

    @Column(name = "commons_param_order")
    private Integer order;

    @Column(name = "commons_param_value", length = 2048)
    private String value;

    @Column(name = "commons_param_parameter_desc", length = 200)
    private String description;

    @Column(name = "commons_param_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_param_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_param_parameter_3", length = 200)
    private String parameter3;

    @Column(name = "commons_param_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;
}
