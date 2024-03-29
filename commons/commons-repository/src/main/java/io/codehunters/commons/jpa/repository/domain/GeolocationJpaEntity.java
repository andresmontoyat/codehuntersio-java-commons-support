package io.codehunters.commons.jpa.repository.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@MappedSuperclass
public abstract class GeolocationJpaEntity<I extends Number> extends JpaEntity<I> {

    @Column(name = "latitude")
    protected Double latitude;

    @Column(name = "longitude")
    protected Double longitude;
}
