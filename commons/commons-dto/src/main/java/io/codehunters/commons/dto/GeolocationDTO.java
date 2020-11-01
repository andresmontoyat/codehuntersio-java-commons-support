package io.codehunters.commons.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class GeolocationDTO<ID> extends DTO<ID> {

    protected Double latitude;

    protected Double longitude;
}
