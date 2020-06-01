package io.codehunters.commons.dto.support.embeddables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmbeddablesDTO<T> {

    protected T id;

    protected Boolean enabled;
}
