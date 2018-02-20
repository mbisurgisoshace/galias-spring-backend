package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GVA17")
public class PrecioTango implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA17")
    private Long id;

    @Column(name = "NRO_DE_LIS")
    private Integer tipo;

    @Column(name = "PRECIO")
    private Double precio;

    public PrecioTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
