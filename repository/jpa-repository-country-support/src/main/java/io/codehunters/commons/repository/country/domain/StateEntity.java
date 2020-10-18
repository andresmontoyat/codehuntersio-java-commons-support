package io.codehunters.commons.repository.country.domain;

import io.codehunters.commons.repository.domain.JpaGeolocation;
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
@Table(name = "commons_states")
public class StateEntity extends JpaGeolocation<Long> {

    @Column(name = "commons_state_name", nullable = false, length = 120)
    private String name;

    @Column(name = "commons_state_code", nullable = false, length = 8)
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;
}
