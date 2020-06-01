package io.codehunters.commons.repository.country.support.domain;

import io.codehunters.commons.repository.domain.support.Geolocation;
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
public class Country extends Geolocation<Long> {

    @Column(name = "commons_country_name", nullable = false, length = 120)
    private String name;

    @Column(name = "commons_country_indicative", nullable = false, length = 8)
    private String indicative;

}
