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

    @Column(name = "TELEFONO_1")
    private String telefono;

    @Column(name = "CUIT")
    private String cuit;

    @Column(name = "COD_GVA23")
    private String vendedor;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
