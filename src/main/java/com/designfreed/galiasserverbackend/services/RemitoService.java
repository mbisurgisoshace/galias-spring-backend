package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.crm.Remito;
import com.designfreed.galiasserverbackend.domain.tango.RemitoTango;
import com.designfreed.galiasserverbackend.domain.view.RemitoView;
import com.designfreed.galiasserverbackend.domain.view.SyncView;
import com.designfreed.galiasserverbackend.services.generics.CRUDService;

import java.util.List;

public interface RemitoService extends CRUDService<RemitoTango, Remito> {
    RemitoTango findTopByInterno();
    String getProximo();
    Boolean sync(RemitoView remito);
    SyncView syncAll(List<RemitoView> remitos);
}
