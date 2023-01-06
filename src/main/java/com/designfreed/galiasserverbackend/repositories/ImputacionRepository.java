package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.ImputacionTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImputacionRepository extends CrudRepository<ImputacionTango, Long> {
    List<ImputacionTango> findAllByComprobanteAndTipoComp(String comprobante, String tipoComp);
}
