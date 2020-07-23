package io.codehunters.commons.dto.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DTO<ID> extends AuditableDTO  {

    protected ID id;

    protected Boolean enabled;

    public abstract <T extends DTO> T withId(ID id);

}