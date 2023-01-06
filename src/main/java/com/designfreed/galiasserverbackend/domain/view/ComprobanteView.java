package com.designfreed.galiasserverbackend.domain.view;

import java.util.ArrayList;
import java.util.List;

public class ComprobanteView {
    private Long fecha;
    private String entidad;
    private String opeacion;
    private String tipo;
    private String comprobante;
    private List<ComprobanteItemView> items;
    private List<String> imputacion;

    public ComprobanteView() {
    }

    public ComprobanteView(Long fecha, String entidad, String operacion, String tipo, String comprobante, List<String> imputacion) {
        this.fecha = fecha;
        this.entidad = entidad;
        this.opeacion = operacion;
        this.tipo = tipo;
        this.comprobante = comprobante;
        this.items = new ArrayList<>();
        this.imputacion = imputacion;
    }

    public ComprobanteView(Long fecha, String entidad, String operacion, String tipo, String comprobante, List<ComprobanteItemView> items, List<String> imputacion) {
        this.fecha = fecha;
        this.entidad = entidad;
        this.opeacion = operacion;
        this.tipo = tipo;
        this.comprobante = comprobante;
        this.items = items;
        this.imputacion = imputacion;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getOpeacion() {
        return opeacion;
    }

    public void setOpeacion(String opeacion) {
        this.opeacion = opeacion;
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

    public List<ComprobanteItemView> getItems() {
        return items;
    }

    public void setItems(List<ComprobanteItemView> items) {
        this.items = items;
    }

    public List<String> getImputacion() {
        return imputacion;
    }

    public void setImputacion(List<String> imputacion) {
        this.imputacion = imputacion;
    }
}
