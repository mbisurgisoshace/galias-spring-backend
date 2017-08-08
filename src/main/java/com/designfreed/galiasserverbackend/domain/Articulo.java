package com.designfreed.galiasserverbackend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STA11")
public class Articulo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_STA11")
    private Long id;

    @Column(name = "COD_ARTICU")
    private String codigo;

    @Column(name = "DESCRIPCIO")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "COD_ARTICU", referencedColumnName = "COD_ARTICU", nullable = false)
    private List<Precio> precios = new ArrayList<>();

    public Articulo() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Precio> getPrecios() {
        return precios;
    }

    public void setPrecios(List<Precio> precios) {
        this.precios = precios;
    }
}
