package io.codehunters.commons.jpa.repository.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "commons_states")
public class StateJpaEntity extends GeolocationJpaEntity<Long> {

    @Column(name = "commons_state_name", length = 120)
    private String name;

    @Column(name = "commons_state_code", length = 8)
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryJpaEntity country;
}
