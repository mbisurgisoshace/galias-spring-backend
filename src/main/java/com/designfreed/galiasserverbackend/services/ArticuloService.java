package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.crm.Articulo;
import com.designfreed.galiasserverbackend.domain.tango.ArticuloTango;
import com.designfreed.galiasserverbackend.services.generics.CRUDService;

public interface ArticuloService extends CRUDService<ArticuloTango, Articulo> {
}
