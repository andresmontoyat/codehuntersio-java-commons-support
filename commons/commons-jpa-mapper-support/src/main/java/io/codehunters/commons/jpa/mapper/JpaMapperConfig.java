package io.codehunters.commons.jpa.mapper;

import io.codehunters.commons.jpa.mapper.JpaMapper;
import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(uses = {JpaMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public class JpaMapperConfig {
}
