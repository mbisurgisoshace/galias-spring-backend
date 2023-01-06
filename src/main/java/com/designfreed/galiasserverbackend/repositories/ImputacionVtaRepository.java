package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.ImputacionVta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImputacionVtaRepository extends CrudRepository<ImputacionVta, Long> {
    List<ImputacionVta> findAllByNumCompCanAndTipoCompCan(String numCompCan, String tipoCompCan);
}
