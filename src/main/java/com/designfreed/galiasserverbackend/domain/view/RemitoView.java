package com.designfreed.galiasserverbackend.domain.view;

import java.util.Date;
import java.util.List;

public class RemitoView {
    private Date fecha;
    private String pedido;
    private String cliente;
    private List<RemitoViewItem> items;

    public RemitoView() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<RemitoViewItem> getItems() {
        return items;
    }

    public void setItems(List<RemitoViewItem> items) {
        this.items = items;
    }
}
