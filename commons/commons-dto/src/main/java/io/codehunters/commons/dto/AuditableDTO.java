package io.codehunters.commons.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public abstract class AuditableDTO {

    protected String createdBy;

    protected Date createdDate;

    protected String modifiedBy;

    protected Date lastModifiedDate;

    protected Long version;
}
