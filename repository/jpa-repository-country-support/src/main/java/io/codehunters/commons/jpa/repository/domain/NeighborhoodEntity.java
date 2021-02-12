package io.codehunters.commons.jpa.repository.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commons_neighborhoods")
public class NeighborhoodEntity extends GeolocationJpaEntity<Long> {

    @Column(name = "commons_neighborhood_name", nullable = false, length = 120)
    private String name;

    @Column(name = "commons_neighborhood_code", nullable = false, length = 8)
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity city;
}
