package io.codehunters.commons.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class GeolocationDTO<ID> extends DTO<ID> {

    protected Double latitude;

    protected Double longitude;
}
