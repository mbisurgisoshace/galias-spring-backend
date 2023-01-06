package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.tango.StockTango;
import com.designfreed.galiasserverbackend.services.generics.CRUDService;

import java.util.List;

public interface StockService extends CRUDService<StockTango, Long> {
    Integer findStockByArticulo(String articulo);
    Boolean hasStock(String articulo, String deposito, Integer cantidad);
}
