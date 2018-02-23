package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.DireccionEntregaTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionEntregaRepository extends CrudRepository<DireccionEntregaTango, Long> {
    void deleteByCliente(String cliente);
}