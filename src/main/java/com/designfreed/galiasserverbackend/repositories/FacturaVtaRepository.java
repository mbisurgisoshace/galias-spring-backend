package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.FacturaVtaTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaVtaRepository extends CrudRepository<FacturaVtaTango, Long> {
    List<FacturaVtaTango> findAllByClienteAndEstado(String cliente, String Estado);
}
