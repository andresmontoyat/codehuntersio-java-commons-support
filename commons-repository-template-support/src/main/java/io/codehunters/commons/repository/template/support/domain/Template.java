package io.codehunters.commons.repository.template.support.domain;

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
@Table(name = "commons_notif_templates",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"commons_notif_templ_group", "commons_notif_templ_code"})
        })
public class Template extends Entities<Long> {

    @Column(name = "commons_notif_templ_group", nullable = false, length = 80)
    private String group;

    @Column(name = "commons_notif_templ_code", unique = true, nullable = false, length = 80)
    private String code;

    @Column(name = "commons_notif_templ_is_mail")
    private Boolean mail;

    @Column(name = "commons_notif_templ_is_sms")
    private Boolean sms;

    @Column(name = "commons_notif_templ_is_push")
    private Boolean push;

    @Column(name = "commons_notif_templ_subject", length = 120)
    private String subject;

    @Column(name = "commons_notif_templ_body", columnDefinition = "text")
    private String body;

    @Column(name = "commons_notif_templ_desc", length = 200)
    private String description;

    @Column(name = "commons_notif_templ_parameter_1", length = 200)
    private String parameter1;

    @Column(name = "commons_notif_templ_parameter_2", length = 200)
    private String parameter2;

    @Column(name = "commons_notif_templ_parameter_3", length = 200)
    private String parameter3;

    public boolean isMail() {
        return this.mail;
    }

    public boolean isSms() {
        return this.sms;
    }

    public boolean isPush() {
        return this.push;
    }
}
