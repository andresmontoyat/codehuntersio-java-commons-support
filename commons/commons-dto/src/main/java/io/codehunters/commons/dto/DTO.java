package io.codehunters.commons.dto;

import lombok.*;

@Getter
@Setter
public abstract class DTO<ID> extends AuditableDTO {

    protected ID id;

    public abstract <T extends DTO> T withId(ID id);
}