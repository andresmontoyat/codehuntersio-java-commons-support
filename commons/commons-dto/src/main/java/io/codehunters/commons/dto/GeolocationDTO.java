package io.codehunters.commons.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public abstract class GeolocationDTO<ID> extends DTO<ID> {

    protected Double latitude;

    protected Double longitude;
}
