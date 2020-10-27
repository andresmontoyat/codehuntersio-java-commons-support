package io.codehunters.commons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class AuditableDTO {

    protected String createdBy;

    protected Date createdDate;

    protected String modifiedBy;

    protected Date lastModifiedDate;

    protected Long version;
}
