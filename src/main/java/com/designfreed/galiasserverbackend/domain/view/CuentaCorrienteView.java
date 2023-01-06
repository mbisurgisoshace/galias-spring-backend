package com.designfreed.galiasserverbackend.domain.view;

import com.designfreed.galiasserverbackend.domain.tango.FacturaVtaTango;

import java.util.Date;
import java.util.List;

public class CuentaCorrienteView {
    private List<FacturaVtaTango> pendientes;
    private Float total;

    public CuentaCorrienteView() {
    }

    public List<FacturaVtaTango> getPendientes() {
        return pendientes;
    }

    public void setPendientes(List<FacturaVtaTango> pendientes) {
        this.pendientes = pendientes;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
