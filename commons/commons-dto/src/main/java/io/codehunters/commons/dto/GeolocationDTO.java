package io.codehunters.commons.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class GeolocationDTO<ID> extends DTO<ID> {

    protected Double latitude;

    protected Double longitude;
}
