package io.codehunters.commons.repository.parameter.support.domain;

import io.codehunters.commons.repository.domain.support.Entities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_parameters",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"commons_param_application", "commons_param_group", "commons_param_code"})
        })
public class Parameter extends Entities<Long> {

    @Column(name = "commons_param_application", nullable = false, length = 80)
    private String application;

    @Column(name = "commons_param_group", nullable = false, length = 80)
    private String group;

    @Column(name = "commons_param_name", nullable = false, length = 80)
    private String name;

    @Column(name = "commons_param_code", nullable = false, length = 80)
    private String code;

    @Column(name = "commons_param_order")
    private Integer order;

    @Column(name = "commons_param_value", length = 2048)
    private String value;

    @Column(name = "commons_param_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_param_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_param_parameter_3", length = 200)
    private String parameter3;

}
