package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.TalonarioTango;
import org.springframework.data.repository.CrudRepository;

public interface TalonarioRepository extends CrudRepository<TalonarioTango, Long> {
    TalonarioTango findByTipoAndSucursal(String tipo, String sucursal);
}
