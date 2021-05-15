package io.codehunters.commons.jpa.repository.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "commons_neighborhoods")
public class NeighborhoodJpaEntity extends GeolocationJpaEntity<Long> {

    @Column(name = "commons_neighborhood_name", length = 120)
    private String name;

    @Column(name = "commons_neighborhood_code", length = 8)
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityJpaEntity city;
}
