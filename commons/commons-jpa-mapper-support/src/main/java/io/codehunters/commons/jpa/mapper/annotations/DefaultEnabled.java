package io.codehunters.commons.jpa.mapper.annotations;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "enabled", constant = "true")
public @interface DefaultEnabled {
}
