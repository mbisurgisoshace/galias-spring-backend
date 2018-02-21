package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DIRECCION_ENTREGA")
public class DireccionEntregaTango implements Serializable {
    @TableGenerator(name = "direccion-gen", table = "PROVIDERID", pkColumnName = "ID_PROVIDERID", valueColumnName = "ULTIMOID", pkColumnValue = "8", allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "direccion-gen")
    @Column(name = "ID_DIRECCION_ENTREGA")
    private Long id;

    @Column(name = "COD_DIRECCION_ENTREGA")
    private String codigo;

    @Column(name = "COD_CLIENTE")
    private String cliente;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "COD_PROVINCIA")
    private String provincia;

    @Column(name = "LOCALIDAD")
    private String localidad;

    @Column(name = "HABITUAL")
    private String habitual;

    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;

    @Column(name = "TELEFONO1")
    private String telefono;

    @Column(name = "HABILITADO")
    private String habilitado;

    public DireccionEntregaTango() {
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getHabitual() {
        return habitual;
    }

    public void setHabitual(String habitual) {
        this.habitual = habitual;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
}
