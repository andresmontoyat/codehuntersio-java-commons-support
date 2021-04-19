package io.codehunters.commons.jpa.repository.template.domain;

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
@Table(name = "commons_notif_templates")
public class TemplateJpaEntities extends JpaEntities<Long> {

    @Column(name = "commons_notif_templ_name", nullable = false, length = 80)
    private String name;

    @Column(name = "commons_notif_templ_code", nullable = false, length = 20)
    private String code;

    @Column(name = "commons_notif_templ_is_mail")
    private Boolean mail;

    @Column(name = "commons_notif_templ_is_sms")
    private Boolean sms;

    @Column(name = "commons_notif_templ_is_push")
    private Boolean push;

    @Column(name = "commons_notif_templ_is_web")
    private Boolean web;

    @Column(name = "commons_notif_templ_subject", length = 120)
    private String subject;

    @Column(name = "commons_notif_templ_body", length = 800)
    private String body;

    @Column(name = "commons_notif_templ_desc", length = 200)
    private String description;

    @Column(name = "commons_notif_templ_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_notif_templ_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_notif_templ_parameter_3", length = 200)
    private String parameter3;

    @Column(name = "commons_notif_templ_additional_info", length = 400)
    @Convert(converter = MapStringKeyWithStringValueConverter.class)
    private Map<String, String> additionalInfo;

}