package io.codehunters.commons.repository.country.domain;

import io.codehunters.commons.repository.domain.JpaGeolocation;
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
public class Country extends JpaGeolocation<Long> {

    @Column(name = "commons_country_name", nullable = false, length = 120)
    private String name;

    @Column(name = "commons_country_indicative", nullable = false, length = 8)
    private String indicative;
}
