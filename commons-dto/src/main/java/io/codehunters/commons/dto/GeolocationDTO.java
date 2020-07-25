package io.codehunters.commons.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GeolocationDTO<ID> extends DTO<ID> {

    protected Double latitude;

    protected Double longitude;
}
