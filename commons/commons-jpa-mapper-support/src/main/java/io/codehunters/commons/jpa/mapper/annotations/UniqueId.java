package io.codehunters.commons.jpa.mapper.annotations;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "uniqueId", expression = "java(io.codehunters.commons.util.Util.uuid())")
public @interface UniqueId {
}
