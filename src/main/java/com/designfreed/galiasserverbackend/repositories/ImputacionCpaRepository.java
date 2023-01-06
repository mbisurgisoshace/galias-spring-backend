package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.ImputacionCpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImputacionCpaRepository extends CrudRepository<ImputacionCpa, Long> {
    List<ImputacionCpa> findAllByNumCompCanAndTipoCompCan(String numCompCan, String tipoCompCan);
}
