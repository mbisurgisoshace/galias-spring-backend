package com.designfreed.galiasserverbackend.services;

import com.designfreed.galiasserverbackend.domain.view.CuentaCorrienteView;

public interface CuentaCorrienteService {
    CuentaCorrienteView getCuentaCorriente(String cliente);
}
