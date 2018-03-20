package com.designfreed.galiasserverbackend.domain.crm;

public class Equivalencia {
    private Unidad unidad;
    private Integer equivalencia;
    private Boolean defecto;

    public Equivalencia() {
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Integer getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Integer equivalencia) {
        this.equivalencia = equivalencia;
    }

    public Boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(Boolean defecto) {
        this.defecto = defecto;
    }
}
