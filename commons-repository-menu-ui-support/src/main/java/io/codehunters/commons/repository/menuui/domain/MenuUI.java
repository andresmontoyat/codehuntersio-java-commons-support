package io.codehunters.commons.repository.menuui.domain;

import io.codehunters.commons.repository.domain.support.Entities;
import io.codehunters.commons.repository.domain.support.converter.MapStringKeyWithStringValueConverter;
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
@Table(name = "commons_menu_ui")
public class MenuUI extends Entities<Long> {

    @Column(name = "commons_menu_name", nullable = false, length = 80)
    private String name;

    @Column(name = "commons_menu_url", length = 200)
    private String url;

    @Column(name = "commons_menu_imageicon", length = 200)
    private String imageIcon;

    @Column(name = "commons_menu_desc", length = 200)
    private String description;

    @Column(name = "commons_menu_additional_info", length = 400)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;

    @Column(name = "commons_menu_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_menu_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_menu_parameter_3", length = 200)
    private String parameter3;
}
