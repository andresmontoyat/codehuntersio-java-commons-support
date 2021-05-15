package io.codehunters.commons.jpa.repository.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "commons_countries")
public class CountryJpaEntity extends GeolocationJpaEntity<Long> {

    @Column(name = "commons_country_name", length = 120)
    private String name;

    @Column(name = "commons_country_indicative", length = 40)
    private String indicative;

    @Column(name = "commons_country_code", length = 8)
    private String code;

    @Column(name = "commons_country_enabled")
    private Boolean enabled;
}
