package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.ComprobanteVta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprobanteVtaRepository extends CrudRepository<ComprobanteVta, Long> {
    List<ComprobanteVta> findAllByProcesado(Boolean procesado);
}
