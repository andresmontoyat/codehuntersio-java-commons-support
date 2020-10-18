package io.codehunters.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DTO<ID> extends AuditableDTO {

    protected ID id;

    public abstract <T extends DTO> T withId(ID id);
}