package com.designfreed.galiasserverbackend.repositories;

import com.designfreed.galiasserverbackend.domain.tango.StockTango;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<StockTango, Long> {
    List<StockTango> findByArticulo(String articulo);
    StockTango findByArticuloAndDeposito(String articulo, String deposito);
}
