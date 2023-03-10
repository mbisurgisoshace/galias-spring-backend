package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.DireccionEntregaTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionEntregaRepository extends CrudRepository<DireccionEntregaTango, Long> {
    DireccionEntregaTango findByCodigoAndCliente(String codigo, String cliente);
    void deleteByCliente(String cliente);
}