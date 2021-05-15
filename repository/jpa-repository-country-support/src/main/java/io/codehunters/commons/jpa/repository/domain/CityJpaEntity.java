package io.codehunters.commons.jpa.repository.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "commons_cities")
public class CityJpaEntity extends GeolocationJpaEntity<Long> {

    @Column(name = "commons_city_name", length = 120)
    private String name;

    @Column(name = "commons_city_code", length = 8)
    private String code;

    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private StateJpaEntity state;
}
