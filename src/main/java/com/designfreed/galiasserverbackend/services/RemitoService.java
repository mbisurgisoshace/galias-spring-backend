package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.crm.Remito;
import com.designfreed.galiasserverbackend.domain.tango.RemitoTango;
import com.designfreed.galiasserverbackend.services.generics.CRUDService;

public interface RemitoService extends CRUDService<RemitoTango, Remito> {
    RemitoTango findTopByInterno();
}
