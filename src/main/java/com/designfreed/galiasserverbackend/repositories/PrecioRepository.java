package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.PrecioTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecioRepository extends CrudRepository<PrecioTango, Long> {
    PrecioTango findByArticuloAndNumero(String articulo, Integer numero);
}
