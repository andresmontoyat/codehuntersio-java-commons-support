package io.codehunters.commons.jpa.repository.menuui.domain;

import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.jpa.repository.domain.JpaEntities;
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
@Table(name = "commons_menu_ui")
public class MenuUIEntities extends JpaEntities<Long> {

    @Column(name = "commons_menu_name", nullable = false, length = 80)
    private String name;

    @Column(name = "commons_menu_url", length = 200)
    private String url;

    @Column(name = "commons_menu_imageicon", length = 200)
    private String imageIcon;

    @Column(name = "commons_menu_desc", length = 200)
    private String description;

    @Column(name = "commons_menu_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_menu_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_menu_parameter_3", length = 200)
    private String parameter3;

    @Column(name = "commons_menu_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;

    @ManyToOne
    @JoinColumn(name = "parent_menu_id", referencedColumnName = "id")
    private MenuUIEntities parent;

    @OneToMany(mappedBy = "parent")
    private List<MenuUIEntities> submenus;
}
