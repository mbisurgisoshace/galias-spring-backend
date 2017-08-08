package com.designfreed.galiasserverbackend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GVA14")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA14")
    private Long id;

    @Column(name = "COD_CLIENT")
    private String codigo;

    @Column(name = "RAZON_SOCI")
    private String razonSocial;

    @Column(name = "DOMICILIO")
    private String direccion;

    @Column(name = "E_MAIL")
    private String email;

    @Column(name = "CUIT")
    private String cuit;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
