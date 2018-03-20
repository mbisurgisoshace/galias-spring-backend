package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.EquivalenciaTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquivalenciaRepository extends CrudRepository<EquivalenciaTango, Long> {
    EquivalenciaTango findByArticulo(Long articulo);
}
