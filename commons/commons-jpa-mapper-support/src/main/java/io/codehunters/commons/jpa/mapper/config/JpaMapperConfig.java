package io.codehunters.commons.jpa.mapper.config;

import io.codehunters.commons.jpa.mapper.JpaMapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring", uses = {JpaMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class JpaMapperConfig {
}
