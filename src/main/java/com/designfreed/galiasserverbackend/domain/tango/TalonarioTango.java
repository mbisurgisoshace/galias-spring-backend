package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GVA43")
public class TalonarioTango implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA43")
    private Long id;

    @Column(name = "COMPROB")
    private String tipo;

    @Column(name = "PROXIMO")
    private String proximo;

    @Column(name = "SUCURSAL")
    private String sucursal;

    public TalonarioTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProximo() {
        return proximo;
    }

    public void setProximo(String proximo) {
        this.proximo = proximo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
}
