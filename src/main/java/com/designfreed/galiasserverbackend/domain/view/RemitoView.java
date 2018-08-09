package com.designfreed.galiasserverbackend.domain.view;

import java.util.Date;

public class RemitoView {
    private Date fecha;
    private String cliente;
    private RemitoViewItem items;

    public RemitoView() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public RemitoViewItem getItems() {
        return items;
    }

    public void setItems(RemitoViewItem items) {
        this.items = items;
    }
}
