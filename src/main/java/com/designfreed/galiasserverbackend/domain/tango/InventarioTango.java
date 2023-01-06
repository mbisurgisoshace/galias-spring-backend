package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STA19")
public class InventarioTango implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_STA19")
    private Long id;

    @Column(name = "CANT_STOCK")
    private Float cantidad;

    @Column(name = "COD_ARTICU")
    private String articulo;

    @Column(name = "COD_DEPOSI")
    private String deposito;

    public InventarioTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }
}
