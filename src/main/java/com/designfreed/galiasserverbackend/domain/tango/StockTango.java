package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;

@Entity
@Table(name = "STA19")
public class StockTango {
    @Id
    @GeneratedValue
    @Column(name = "ID_STA19")
    private Long id;

    @Column(name = "COD_ARTICU")
    private String articulo;

    @Column(name = "CANT_STOCK")
    private Integer cantidad;

    @Column(name = "COD_DEPOSI")
    private String deposito;

    public StockTango() {
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }
}
