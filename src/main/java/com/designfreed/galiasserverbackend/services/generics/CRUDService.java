package com.designfreed.galiasserverbackend.services.generics;

import java.util.List;

public interface CRUDService<T> {
    List<T> findAll();

    T findById(Long id);
}
