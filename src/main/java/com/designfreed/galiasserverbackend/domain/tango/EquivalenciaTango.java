package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STA_ARTICULO_UNIDAD_COMPRA")
public class EquivalenciaTango implements Serializable {
    @TableGenerator(name = "equivalencia-gen", table = "PROVIDERID", pkColumnName = "ID_PROVIDERID", valueColumnName = "ULTIMOID", pkColumnValue = "11", allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "equivalencia-gen")
    @Column(name = "ID_STA_ARTICULO_UNIDAD_COMPRA")
    private Long id;

    @Column(name = "ID_STA11")
    private Long articulo;

    @Column(name = "ID_MEDIDA_COMPRA")
    private Integer unidad;

    @Column(name = "EQUIVALENCIA")
    private Float equivalencia;

    @Column(name = "HABITUAL")
    private Boolean habitual;

    public EquivalenciaTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticulo() {
        return articulo;
    }

    public void setArticulo(Long articulo) {
        this.articulo = articulo;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public Float getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Float equivalencia) {
        this.equivalencia = equivalencia;
    }

    public Boolean getHabitual() {
        return habitual;
    }

    public void setHabitual(Boolean habitual) {
        this.habitual = habitual;
    }
}
