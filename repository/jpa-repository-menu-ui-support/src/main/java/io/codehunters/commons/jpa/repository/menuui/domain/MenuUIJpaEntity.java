package io.codehunters.commons.jpa.repository.menuui.domain;

import io.codehunters.commons.jpa.repository.converter.MapStringKeyWithStringValueConverter;
import io.codehunters.commons.jpa.repository.domain.JpaEntity;
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
@Table(name = "commons_menu_ui")
public class MenuUIJpaEntity extends JpaEntity<Long> {

    @Column(name = "commons_menu_name", length = 80)
    private String name;

    @Column(name = "commons_menu_url", length = 200)
    private String url;

    @Column(name = "commons_menu_imageicon", length = 200)
    private String imageIcon;

    @Column(name = "commons_menu_desc", length = 200)
    private String description;

    @Column(name = "commons_menu_additional_info", length = 800)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;

    @Column(name = "commons_menu_parent_id")
    private Long parentId;

}
