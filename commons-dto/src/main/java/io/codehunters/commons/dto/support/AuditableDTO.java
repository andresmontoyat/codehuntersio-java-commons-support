package io.codehunters.commons.dto.support;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AuditableDTO implements Serializable {

    protected String createdBy;

    protected Date createdDate;

    protected String modifiedBy;

    protected Date lastModifiedDate;
}
