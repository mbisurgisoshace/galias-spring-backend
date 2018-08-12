package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.RemitoTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemitoRepository extends CrudRepository<RemitoTango, Long> {
    RemitoTango findFirst1ByOrderByInternoDesc();
    RemitoTango findFirst1ByTalonarioOrderByComprobanteDesc(Integer talonario);
}
