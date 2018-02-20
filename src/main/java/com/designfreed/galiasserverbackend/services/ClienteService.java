package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.crm.Cliente;
import com.designfreed.galiasserverbackend.domain.tango.ClienteTango;
import com.designfreed.galiasserverbackend.services.generics.CRUDService;

public interface ClienteService extends CRUDService<ClienteTango, Cliente> {
}
