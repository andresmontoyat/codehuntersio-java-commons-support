package io.codehunters.commons.repository.domain.support;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class Geolocation<ID extends Serializable> extends Entities<ID> {

    @Column(name = "latitude")
    protected Double latitude;

    @Column(name = "longitude")
    protected Double longitude;
}
