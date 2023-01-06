package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.ComprobanteCpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprobanteCpaRepository extends CrudRepository<ComprobanteCpa, Long> {
    List<ComprobanteCpa> findAllByProcesado(Boolean procesado);
}
