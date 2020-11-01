package io.codehunters.commons.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class DTO<ID> extends AuditableDTO {

    protected ID id;

    public abstract <T extends DTO> T withId(ID id);
}