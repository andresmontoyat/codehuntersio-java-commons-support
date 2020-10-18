package io.codehunters.commons.repository.domain;

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
public abstract class JpaGeolocation<ID extends Serializable> extends JpaEntities<ID> {

    @Column(name = "latitude")
    protected Double latitude;

    @Column(name = "longitude")
    protected Double longitude;
}
