package io.codehunters.commons.repository.domain.embeddables;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class JpaEmbeddables<T> implements Serializable {

    protected T id;

    public JpaEmbeddables()  {

    }
}
