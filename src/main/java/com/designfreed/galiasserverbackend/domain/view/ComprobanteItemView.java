package com.designfreed.galiasserverbackend.domain.view;

public class ComprobanteItemView {
    private String articulo;
    private Long fecha;
    private String operacion;
    private String tipo;
    private String comprobante;
    private Integer cantidad;
    private Double precio;

    public ComprobanteItemView() {
    }

    public ComprobanteItemView(String articulo, Integer cantidad, Double precio) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ComprobanteItemView(String articulo, Long fecha, String operacion, String tipo, String comprobante, Integer cantidad, Double precio) {
        this.articulo = articulo;
        this.fecha = fecha;
        this.operacion = operacion;
        this.tipo = tipo;
        this.comprobante = comprobante;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
