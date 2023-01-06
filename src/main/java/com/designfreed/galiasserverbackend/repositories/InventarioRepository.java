package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.InventarioTango;
import org.springframework.data.repository.CrudRepository;

public interface InventarioRepository extends CrudRepository<InventarioTango, Long> {
    InventarioTango findByArticuloAndDeposito(String articulo, String deposito);
}
