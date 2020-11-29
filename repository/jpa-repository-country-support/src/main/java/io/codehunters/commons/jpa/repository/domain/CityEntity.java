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
@Table(name = "commons_cities")
public class CityEntity extends JpaGeolocation<Long> {

    @Column(name = "commons_city_name", nullable = false, length = 120)
    private String name;

    @Column(name = "commons_city_code", nullable = false, length = 8)
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private StateEntity state;
}
