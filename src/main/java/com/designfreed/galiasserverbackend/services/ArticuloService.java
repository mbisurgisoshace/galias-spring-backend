package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.crm.Articulo;
import com.designfreed.galiasserverbackend.domain.tango.ArticuloTango;
import com.designfreed.galiasserverbackend.services.generics.CRUDService;

import java.util.List;

public interface ArticuloService extends CRUDService<ArticuloTango, Articulo> {
    ArticuloTango findByCodigo(String codigo);
    Boolean precios(List<Articulo> articulos);
}
