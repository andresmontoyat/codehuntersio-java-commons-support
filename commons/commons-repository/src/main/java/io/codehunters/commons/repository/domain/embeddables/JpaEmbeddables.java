package io.codehunters.commons.repository.domain.embeddables;

import lombok.Data;

@Data
public abstract class JpaEmbeddables<T> {

    protected T id;

    public JpaEmbeddables()  {

    }

    public boolean isNew() {
        return (this.id == null);
    }
}
