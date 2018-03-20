package com.designfreed.galiasserverbackend.domain.crm;

import java.util.List;

public class Articulo {
    private String codigo;
    private String descripcion;
    private Double iva;
    private Boolean lote;
    private Unidad unidadStock;
    private List<Equivalencia> unidadesCpa;
    private List<Equivalencia> unidadesVta;
    private Double precioVta;

    public Articulo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Boolean getLote() {
        return lote;
    }

    public void setLote(Boolean lote) {
        this.lote = lote;
    }

    public Unidad getUnidadStock() {
        return unidadStock;
    }

    public void setUnidadStock(Unidad unidadStock) {
        this.unidadStock = unidadStock;
    }

    public List<Equivalencia> getUnidadesCpa() {
        return unidadesCpa;
    }

    public void setUnidadesCpa(List<Equivalencia> unidadesCpa) {
        this.unidadesCpa = unidadesCpa;
    }

    public List<Equivalencia> getUnidadesVta() {
        return unidadesVta;
    }

    public void setUnidadesVta(List<Equivalencia> unidadesVta) {
        this.unidadesVta = unidadesVta;
    }

    public Double getPrecioVta() {
        return precioVta;
    }

    public void setPrecioVta(Double precioVta) {
        this.precioVta = precioVta;
    }
}
