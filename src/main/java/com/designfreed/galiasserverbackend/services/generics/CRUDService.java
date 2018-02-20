package com.designfreed.galiasserverbackend.services.generics;

import java.util.List;

public interface CRUDService<T, C> {
    List<T> findAll();

    T findById(Long id);

    T saveOrUpdate(C domainObject);
}
