package io.codehunters.commons.dto.mapper.annotations;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "createdBy", ignore = true)
@Mapping(target = "createdDate", ignore = true)
@Mapping(target = "modifiedBy", ignore = true)
@Mapping(target = "lastModifiedDate", ignore = true)
public @interface IgnoreAuditable {

}
