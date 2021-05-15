package io.codehunters.commons.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class GeolocationDTO<I extends Serializable> extends DTO<I> {

    protected Double latitude;

    protected Double longitude;
}
