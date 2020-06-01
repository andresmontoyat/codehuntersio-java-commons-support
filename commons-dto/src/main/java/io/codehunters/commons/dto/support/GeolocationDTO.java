package io.codehunters.commons.dto.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GeolocationDTO<D> extends DTO<D> {

    protected Double latitude;

    protected Double longitude;
}
