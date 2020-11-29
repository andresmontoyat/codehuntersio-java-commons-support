package io.codehunters.commons.jpa.repository.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_countries")
public class CountryEntity extends JpaGeolocation<Long> {

    @Column(name = "commons_country_name", nullable = false, length = 120)
    private String name;

    @Column(name = "commons_country_indicative", nullable = false, length = 40)
    private String indicative;

    @Column(name = "commons_country_code", nullable = false, length = 8)
    private String code;

    @Column(name = "commons_country_enabled", nullable = false)
    private Boolean enabled;
}
