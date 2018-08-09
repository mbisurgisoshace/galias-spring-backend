package com.designfreed.galiasserverbackend.domain.view;

public class RemitoViewItem {
    private String articulo;
    private Integer cantidad;
    private Float precio;

    public RemitoViewItem() {
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
