package io.codehunters.commons.dto.mapper.annotations;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "id", ignore = true)
@Mapping(target = "createdBy", ignore = true)
@Mapping(target = "createdDate", ignore = true)
@Mapping(target = "modifiedBy", ignore = true)
@Mapping(target = "lastModifiedDate", ignore = true)
@Mapping(target = "version", ignore = true)
public @interface ToEntity {

}
