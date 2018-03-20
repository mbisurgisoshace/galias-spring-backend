package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GVA17")
public class PrecioTango {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA17")
    private Long id;

    @Column(name = "COD_ARTICU")
    private String articulo;

    @Column(name = "NRO_DE_LIS")
    private Integer numero;

    @Column(name = "PRECIO")
    private Double precio;

    @Column(name = "FECHA_MODI")
    private Date fechaModificacion;

    public PrecioTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
