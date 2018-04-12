package com.designfreed.galiasserverbackend.domain.crm;

import java.util.Date;
import java.util.List;

public class Remito {
    private Date fecha;
    private String numero;
    private Cliente cliente;
    private List<RemitoItem> items;

    public Remito() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<RemitoItem> getItems() {
        return items;
    }

    public void setItems(List<RemitoItem> items) {
        this.items = items;
    }
}
