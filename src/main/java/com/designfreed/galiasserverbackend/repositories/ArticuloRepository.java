package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.Articulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
}
