package io.codehunters.commons.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AuditableDTO {

    protected String createdBy;

    protected Date createdDate;

    protected String modifiedBy;

    protected Date lastModifiedDate;
}
