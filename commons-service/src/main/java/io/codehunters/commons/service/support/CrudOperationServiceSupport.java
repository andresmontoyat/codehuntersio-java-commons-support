package io.codehunters.commons.service.support;

import java.util.List;

public interface CrudOperationServiceSupport<ID, D> {

    Long count();

    boolean exists(ID id);

    List<D> findAll();

    D findById(ID id);

    D save(D dto);

    List<D> saveAll(List<D> dto);

    D update(D dto);

    void deleteById(ID id);

    void deleteAll();

    D changeEnabled(ID id, Boolean enabled);
}
