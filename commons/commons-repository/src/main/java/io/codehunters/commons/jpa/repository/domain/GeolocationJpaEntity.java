package io.codehunters.commons.jpa.repository.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class GeolocationJpaEntity<I extends Serializable> extends JpaEntities<I> {

    @Column(name = "latitude")
    protected Double latitude;

    @Column(name = "longitude")
    protected Double longitude;
}
